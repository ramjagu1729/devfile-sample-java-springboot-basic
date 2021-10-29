package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FalconuserRepository extends CrudRepository<Falconuser, Integer> {
	
	
	    @Query("SELECT u FROM Falconuser u WHERE u.email = ?1")
	    public Falconuser findByEmail(String email);
	     


}
