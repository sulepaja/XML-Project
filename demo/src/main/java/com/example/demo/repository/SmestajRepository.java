package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Smestaj;

@Repository
public interface SmestajRepository extends MongoRepository<Smestaj, String>{

}
