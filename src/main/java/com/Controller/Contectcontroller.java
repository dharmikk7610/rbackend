package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Contectentity;
import com.Repositry.Contentsrepo;

@RequestMapping("/message")
@RestController
public class Contectcontroller {

	@Autowired
	Contentsrepo crepo ;
	
	@PostMapping("/sendmessage")
	public ResponseEntity<?> Sendmessage(@RequestBody Contectentity ce)
	{
		Contectentity c = crepo.save(ce);
		return ResponseEntity.ok(c) ;
	}
	
	@GetMapping("/showallmessage")
	public ResponseEntity<?> Showallmessage()
	{
		List<Contectentity> list = crepo.findAll();
		return ResponseEntity.ok(list);
	}
}
