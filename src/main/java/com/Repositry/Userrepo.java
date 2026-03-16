package com.Repositry;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Userappoinmententiy;

@Repository
public interface Userrepo extends JpaRepository<Userappoinmententiy, UUID> {

	

}
