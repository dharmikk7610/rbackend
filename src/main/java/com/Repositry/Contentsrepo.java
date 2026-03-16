package com.Repositry;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Contectentity;

@Repository
public interface Contentsrepo extends JpaRepository<Contectentity, UUID> {

	
}
