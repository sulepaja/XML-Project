package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Soba;

@Repository
public interface SobaRepository extends MongoRepository<Soba, String>{
	
	@Query("{'_id':?0}")	
	Soba getSmestajID(String roomID);
}
