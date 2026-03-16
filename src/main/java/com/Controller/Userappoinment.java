package com.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Eventadminentity;
import com.Entity.Eventuserentity;
import com.Entity.Userappoinmententiy;
import com.Repositry.Eventrepo;
import com.Repositry.Eventuserrepo;
import com.Repositry.Userrepo;

@RestController
@RequestMapping("/user")
public class Userappoinment {
	
	@Autowired
	Userrepo userrepo ;
	
	@Autowired
	Eventrepo eventrepo ;
	
	@Autowired
	Eventuserrepo euserrepo ;

	@PostMapping("/addappointment")
	public ResponseEntity<Userappoinmententiy> addAppointment(
	        @RequestBody Userappoinmententiy u) {
	    Userappoinmententiy saved = userrepo.save(u);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

	@GetMapping("/showappoinment")
	public ResponseEntity<List<Userappoinmententiy>> showAppointment() {
	    List<Userappoinmententiy> list = userrepo.findAll();
	    return ResponseEntity.ok(list);
	}

	@DeleteMapping("/deleteappointment")
	public ResponseEntity<?> deleteAppointment(@RequestParam UUID id) {

	    Optional<Userappoinmententiy> user = userrepo.findById(id);

	    if (user.isEmpty()) {
	        return ResponseEntity
	                .status(HttpStatus.NOT_FOUND)
	                .body("Appointment ID not found");
	    }

	    userrepo.deleteById(id);  

	    return ResponseEntity
	            .status(HttpStatus.OK)
	            .body("Appointment deleted successfully");
	}
	
	
//	event handle ::
	
	@GetMapping("/deleteevent")
	public ResponseEntity<?> DeleteEvent(@RequestParam String  id)
	{
		UUID id2 = UUID.fromString(id); 
		 Optional<Eventadminentity> op = eventrepo.findById(id2);
		 
		 if(op.isEmpty())
		 {
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
		 }
		 eventrepo.deleteById(id2);
		return ResponseEntity.ok("Delete sucessfully") ;
	}
	
	@GetMapping("/showevent")
	public ResponseEntity<?> Showevent()
	{
		List<Eventadminentity> list = eventrepo.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/Addeventdata")
	public ResponseEntity<?> AddeventData(@RequestBody Eventuserentity data)
	{
		 Eventuserentity saved = euserrepo.save(data) ;
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}
}
