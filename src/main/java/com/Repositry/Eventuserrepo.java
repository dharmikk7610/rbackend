package com.Repositry;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Eventuserentity;

@Repository
public interface Eventuserrepo  extends JpaRepository<Eventuserentity, UUID> {

	

}
