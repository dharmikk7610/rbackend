package com.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Userappoinmententiy {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	UUID id ;
	
	String studentName ;
	String email ;
	String password;
	@Column(length = 10)
	String phone ;
	String course ;
	String date ;
	String time ; 
	String reason ;
//    @Enumerated(EnumType.STRING)
    String status = "pending";
	
    
//    public enum Appointmentstatus{
//    	pending,     
//    	confirmed,   // maps to frontend "confirmed"
//    	completed,   // maps to frontend "completed"
//    	rejected 
//    }
	

}

