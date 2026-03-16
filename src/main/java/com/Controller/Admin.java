package com.Controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Userappoinmententiy;
//import com.Entity.Userappoinmententiy.Appointmentstatus;
import com.Repositry.Userrepo;
import com.Util.Mailsender;

@RestController
@RequestMapping("/admin")
public class Admin {

	@Autowired
	Userrepo userrepo ;
	
	
	
	@Autowired
	Mailsender m1 ;
	
	@GetMapping("/Showappontment")
	public ResponseEntity<?> Showappointments(){
		
		List<Userappoinmententiy> list = userrepo.findAll();
		return ResponseEntity.ok(list);
		
		
	}
	
	@PostMapping("/changedata")
	public ResponseEntity<?> changeStudentData(
	        @RequestParam UUID sid,
	        @RequestBody Userappoinmententiy user) {

	    Optional<Userappoinmententiy> optionalUser = userrepo.findById(sid);

	    if(optionalUser.isEmpty()){
	        return ResponseEntity
	                .badRequest()
	                .body("User not found");
	    }

	    Userappoinmententiy existingUser = optionalUser.get();

	    // set updated data
	    existingUser.setStudentName(user.getStudentName());
	    existingUser.setPhone(user.getPhone());
	    existingUser.setReason(user.getReason());
	    existingUser.setStatus(user.getStatus());
	    existingUser.setTime(user.getTime());
	    existingUser.setPassword(user.getPassword());
	    existingUser.setDate(user.getDate());

	    // save updated data
	    userrepo.save(existingUser);

	    return ResponseEntity.ok("Student data updated successfully");
	}
	@GetMapping("/ChangeStatus")
	public ResponseEntity<?> Changestatusappointment(@RequestParam String id){
		UUID id2 = UUID.fromString(id);
		Optional<Userappoinmententiy> user = userrepo.findById(id2);
		
		if(user.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
		}
		user.get().setStatus("confirmed");
		
		m1.sendMail(user.get().getEmail(), user.get().getStudentName());
		//add token 
		userrepo.save(user.get());
		return ResponseEntity.ok(user.get()) ;
	}
	
	@GetMapping("/ComplateStatus")
	public ResponseEntity<?> Complatestatusappointment(@RequestParam String id){
		UUID id2 = UUID.fromString(id);
		Optional<Userappoinmententiy> user = userrepo.findById(id2);
		
		if(user.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
		}
		user.get().setStatus("completed");
		userrepo.save(user.get());
		return ResponseEntity.ok(user.get()) ;
	}
	
	

}
