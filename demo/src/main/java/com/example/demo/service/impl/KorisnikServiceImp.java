package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Korisnik;
import com.example.demo.repository.KorisnikRepository;
import com.example.demo.service.IKorisnikService;

@Service
public class KorisnikServiceImp implements IKorisnikService{
	
	@Autowired
	KorisnikRepository korisnikRepository;

	@Override
	public Korisnik findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Korisnik> findAll() {
		// TODO Auto-generated method stub
		return korisnikRepository.findAll();
	}

	@Override
	public Korisnik save(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return korisnikRepository.save(korisnik);
	}

	@Override
	public List<Korisnik> saveAll(List<Korisnik> korisnici) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Korisnik delete(Korisnik korisnik) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(List<String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Korisnik findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Optional<Korisnik> getUserByEmail(String email) {
		
		Optional<Korisnik> korisnik =korisnikRepository.findOneByEmail(email);
		
		System.out.println("korisnik servis***");
		
		
		return korisnik;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return (int)korisnikRepository.count();
	}

	@Override
	public Optional<Korisnik> getUserById(String id) {
		// TODO Auto-generated method stub
		return korisnikRepository.findById(id);
	}

	@Override
	public Optional<Korisnik> getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return korisnikRepository.findOneByUsername(username);
	}
}
