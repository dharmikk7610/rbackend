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
public class Contectentity {

	@Id
	@GeneratedValue(strategy =GenerationType.UUID )
	UUID id ;

	String name ;
	String email ;
	String phoneno ;
	String subject ;
	String message ;
}
