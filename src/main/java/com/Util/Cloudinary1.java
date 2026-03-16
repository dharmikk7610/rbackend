package com.Util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.util.ObjectUtils;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


@Configuration
public class Cloudinary1{

	@Bean
	public Cloudinary cloudinary()
	{
		return new Cloudinary(ObjectUtils.asMap("cloud_name" , "dczngjmsb" , "api_key" ,"899889586444528" , "api_secret" , "p3H7IaGIcrI8uKG6357cRQ6PqmQ"));
	}

}
