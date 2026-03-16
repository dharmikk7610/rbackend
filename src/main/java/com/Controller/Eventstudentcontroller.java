package com.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Eventadminentity;
import com.Entity.Eventuserentity;
import com.Repositry.Eventrepo;
import com.Repositry.Eventuserrepo;

@RequestMapping("/event")
@RestController
public class Eventstudentcontroller {

	@Autowired
	Eventuserrepo eurepo ;
	
	@Autowired
	Eventrepo erepo ;
	
	@PostMapping("/addeventstudent")
	public ResponseEntity<?> AddeventStudent(@RequestBody Eventuserentity ev , @RequestParam String eventid)
	{
		UUID eventid2  = UUID.fromString(eventid);
		
		 Optional<Eventadminentity> op = erepo.findById(eventid2);
		 ev.setEventname(op.get().getTitle());
		 LocalDate d = LocalDate.now();
		 ev.setCreateAt(d.now());
		 eurepo.save(ev);
		return ResponseEntity.ok("add student sucessfully-->") ;
	}
	
	@GetMapping("/geteventstudent")
	public ResponseEntity<?> showData()
	{
		List<Eventuserentity> list  = eurepo.findAll();
		return ResponseEntity.ok(list);
	}
	

}
