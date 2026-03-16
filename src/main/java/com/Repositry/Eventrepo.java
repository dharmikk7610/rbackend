package com.Repositry;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Eventadminentity;


@Repository
public interface Eventrepo extends JpaRepository<Eventadminentity, UUID>   {

	

}
