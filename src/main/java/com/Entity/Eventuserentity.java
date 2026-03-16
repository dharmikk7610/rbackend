package com.Entity;

import java.time.LocalDate;
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
public class Eventuserentity {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID )
	UUID id ; 
	String Eventname ;
	String studentName ;
	String email ;
	String phone ;
	String course ;
	String college ;
	String yearSemester ;
	String reason ;
	
	LocalDate createAt ;
}
