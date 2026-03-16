package com.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Eventadminentity {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID )
	UUID id ; 
	
	String title ;
	String description ;
	String type ;
	String date ;
	String mode ; 
	String time ;
	String duration ;
	String location ;
	String  limitedSeats ;
	String bannerImage ;

}
