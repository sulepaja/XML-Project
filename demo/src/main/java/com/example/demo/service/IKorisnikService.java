package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Korisnik;

public interface IKorisnikService {
	Korisnik findOne(String id);
	List<Korisnik> findAll();
	Korisnik save(Korisnik korisnik);
	List<Korisnik> saveAll(List<Korisnik> korisnici);
	Korisnik delete(Korisnik korisnik);
	void delete(List<String> ids);
	Korisnik findByUsername(String username);
	Optional<Korisnik> getUserByEmail(String email);
	int count();

	Optional<Korisnik> getUserById(String id);
	Optional<Korisnik> getUserByUsername(String username);

}
