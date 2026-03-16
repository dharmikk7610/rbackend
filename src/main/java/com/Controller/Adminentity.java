package com.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Eventadminentity;
import com.Repositry.Eventrepo;

@RequestMapping("/event")
@RestController
public class Adminentity {
	
	@Autowired
	Eventrepo erepo ;

	@PostMapping("/addEvent")
	public ResponseEntity<?> Addevent(@RequestBody Eventadminentity ed)
	{
		Eventadminentity e = erepo.save(ed);
		return ResponseEntity.ok(e) ;
	}
	
	@GetMapping("/Showevents")
	public ResponseEntity<?> ViewAll()
	{
		List<Eventadminentity> list = erepo.findAll();
		return ResponseEntity.ok(list);
	}
	
	@DeleteMapping("/deleteevent")
	public ResponseEntity<?> deleteevent(@RequestParam  UUID id)
	{
		Optional<Eventadminentity> op= erepo.findById(id);
		
		if(op.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found id");
		}
		 erepo.deleteById(id);
//		  erepo.save(op.get())
		Map<Object, Object> map = new HashMap<>();
		map.put("message", "data deleted");
		map.put("data", op.get());
		 
		return ResponseEntity.ok(map) ;
	}
	
}
