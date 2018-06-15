package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminKorisnikDto;
import com.example.demo.entities.Korisnik;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminServiceImp implements IAdminService {

	@Autowired
	AdminRepository  adminRepository;
	
	@Override
	public List<AdminKorisnikDto> getAllKorisnik() {
		ModelMapper modelMapper=new ModelMapper();
		List<Korisnik> korisnici=adminRepository.findAll();
		List<AdminKorisnikDto> korisniciDto=new ArrayList<AdminKorisnikDto>();
		for(Korisnik korisnik : korisnici) {
			korisniciDto.add(modelMapper.map(korisnik, AdminKorisnikDto.class));
		}
		return korisniciDto;
		
	}

	@Override
	public void blokKorisnik(int id) {
		// TODO Auto-generated method stub
		Optional<Korisnik> korisnik=adminRepository.findById(Integer.toString(id));
		korisnik.get().setBlokiran(true);
		adminRepository.save(korisnik.get());
		return;
	}

	@Override
	public void aktivirajKorisnik(int id) {
		// TODO Auto-generated method stub
		Optional<Korisnik> korisnik=adminRepository.findById(Integer.toString(id));
		korisnik.get().setBlokiran(false);
		adminRepository.save(korisnik.get());
		return;
	}

	@Override
	public void obrisiKorisnik(int id) {
		// TODO Auto-generated method stub
		adminRepository.deleteById(Integer.toString(id));
		return;
	}
	
	
	
}
