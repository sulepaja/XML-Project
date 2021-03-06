package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.RezultatPretrageDTO;
import com.example.demo.entities.Rezervacija;
import com.example.demo.entities.Smestaj;
import com.example.demo.entities.Soba;
import com.example.demo.entities.Tip;
import com.example.demo.service.ISmestajService;

@RestController
@RequestMapping({"/public/accommodations"})
@CrossOrigin(origins = "*")
public class SmestajController {
	
	@Autowired
	private ISmestajService smestajService;
	
	@RequestMapping(value="/getSmestaj/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getSmestajByID(@PathVariable("id") String id) {
		
		System.out.println("Trazim smestaj sa ID-om: "+id);
		
		Optional<Smestaj> smestaj = smestajService.getSmestajById(id);
		
		return new ResponseEntity<Object>(smestaj, HttpStatus.OK);
	}
	
	
	@RequestMapping(
			value = "/getAll",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Smestaj> getAll(){
		
		System.out.println("Pogodio getAll!");
		return smestajService.getAll();
	}
	
	
	@RequestMapping(
			value = "/getAccommodationByPlace/{place}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Smestaj> getAccommodationByPlace(@PathVariable("place") String place){
		
		return smestajService.getSmestajbyMesto(place);
		
	}
	
	
	@RequestMapping(
			value = "/basicSearch/{place}/{numberOfPersons}/{dateFrom}/{dateTo}/{priceFrom}/{priceTo}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RezultatPretrageDTO basicSearch(@PathVariable("place") String place,
			@PathVariable("numberOfPersons") String numberOfPersons,
			@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo,
			@PathVariable("priceFrom") String priceFrom, @PathVariable("priceTo") String priceTo) throws  DatatypeConfigurationException{
		
		
		RezultatPretrageDTO rezultat = new RezultatPretrageDTO();
		rezultat.setGreska(false);
		
		if(place.contains("undefined") || dateFrom.contains("undefined") || dateTo.contains("undefined") || priceFrom.contains("undefined") || priceTo.contains("undefined")) {
			
			rezultat.setGreska(true);
			return rezultat;
		}
			
		
		System.out.println(place);
		System.out.println(place.substring(1, place.length()-1));
		System.out.println(numberOfPersons);
		System.out.println(numberOfPersons.substring(1, numberOfPersons.length()-1));
		System.out.println(dateFrom);
		System.out.println(dateTo);
		System.out.println(priceFrom);
		System.out.println(priceTo);
		
		
		List<Smestaj> smestaji = smestajService.getSmestajbyMesto(place.substring(1, place.length()-1));
		int brojOsoba = Integer.parseInt(numberOfPersons.substring(1, numberOfPersons.length()-1));
		int cenaOd = Integer.parseInt(priceFrom);
		int cenaDo = Integer.parseInt(priceTo);
//		int brojOsoba = numberOfPersons;
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String splitted[] = dateFrom.substring(1, dateFrom.length()-1).split(",");
		String godinaDolaska = splitted[0].split(":")[1];
		String mesecDolaska = splitted[1].split(":")[1];
		if(mesecDolaska.length()==1)
			mesecDolaska = "0" + mesecDolaska;
		String danDolaska = splitted[2].split(":")[1];
		if(danDolaska.length()==1)
			danDolaska = "0" + danDolaska;
		String datumDolaskaStr = godinaDolaska+"-"+mesecDolaska+"-"+danDolaska;
		
		String splitted2[] = dateTo.substring(1, dateTo.length()-1).split(",");
		String godinaOdlaska = splitted2[0].split(":")[1];
		String mesecOdlaska = splitted2[1].split(":")[1];
		if(mesecOdlaska.length()==1)
			mesecOdlaska = "0" + mesecOdlaska;
		String danOdlaska = splitted2[2].split(":")[1];
		if(danOdlaska.length()==1)
			danOdlaska = "0" + danOdlaska;
		String datumOdlaskaStr = godinaOdlaska+"-"+mesecOdlaska+"-"+danOdlaska;
		
	
		XMLGregorianCalendar datumDolaska = DatatypeFactory.newInstance().newXMLGregorianCalendar(datumDolaskaStr);
		XMLGregorianCalendar datumOdlaska = DatatypeFactory.newInstance().newXMLGregorianCalendar(datumOdlaskaStr);
            
       
		List<Smestaj> trazeniSmestaji = new ArrayList<Smestaj>();
		
		for(Smestaj smestaj : smestaji) {
			for(Soba soba : smestaj.getSobe()) {
				if(soba.getKapacitet()==brojOsoba && (cenaOd<=soba.getCena() && soba.getCena()<=cenaDo)) {
					
					if(soba.getRezervacije().isEmpty()) {		// soba nikada nije rezervisana do sad
						if(!trazeniSmestaji.contains(smestaj)) {
							trazeniSmestaji.add(smestaj);
							continue;
						}
					}
					
					boolean slobodna = true;
					for(Rezervacija rez : soba.getRezervacije()) {
						
						if(isBetween(datumDolaska, rez.getOd(), rez.getDo()) || isBetween(datumOdlaska, rez.getOd(), rez.getDo())) {
							System.out.println("soba "+soba.getBroj()+" je zauzeta tada..");
							slobodna = false;
							break;
						}	
			
					}
					
					if(slobodna) {
						if(!trazeniSmestaji.contains(smestaj)) {
							trazeniSmestaji.add(smestaj);
						}
					}
					
				}
			}
		}
		
		
		System.out.println("Ima ih: " + trazeniSmestaji.size());
		rezultat.setTrazeniSmestaji(trazeniSmestaji);
		
		return rezultat;
		
	}
	
	
	@RequestMapping(
			value = "/advancedSearch/{place}/{numberOfPersons}/{dateFrom}/{dateTo}/{priceFrom}/{priceTo}/{type}/{category}"
					+ "/{parking}/{wifi}/{breakfast}/{half_board}/{board}/{TV}/{kitchen}/{bathroom}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RezultatPretrageDTO advancedSearch(@PathVariable("place") String place,
			@PathVariable("numberOfPersons") String numberOfPersons,
			@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo,
			@PathVariable("priceFrom") String priceFrom, @PathVariable("priceTo") String priceTo,
			@PathVariable("type") String type, @PathVariable("category") String category,
			@PathVariable("parking") boolean parking, @PathVariable("wifi") boolean wifi,
			@PathVariable("breakfast") boolean breakfast, @PathVariable("half_board") boolean half_board,  @PathVariable("board") boolean board, 
			@PathVariable("TV") boolean TV, @PathVariable("kitchen") boolean kitchen, @PathVariable("bathroom") boolean bathroom) throws DatatypeConfigurationException {
		
		
		RezultatPretrageDTO rezultat = new RezultatPretrageDTO();
		rezultat.setGreska(false);
		
		if(place.contains("undefined") || dateFrom.contains("undefined") || dateTo.contains("undefined") || priceFrom.contains("undefined") || priceTo.contains("undefined")) {
			
			rezultat.setGreska(true);
			return rezultat;
		}
			
		
		System.out.println(place);
		System.out.println(place.substring(1, place.length()-1));
		System.out.println(numberOfPersons);
		System.out.println(numberOfPersons.substring(1, numberOfPersons.length()-1));
		System.out.println(dateFrom);
		System.out.println(dateTo);
		System.out.println(priceFrom);
		System.out.println(priceTo);
		
		System.out.println(wifi);
		
		
		int brojOsoba = Integer.parseInt(numberOfPersons.substring(1, numberOfPersons.length()-1));
		int cenaOd = Integer.parseInt(priceFrom);
		int cenaDo = Integer.parseInt(priceTo);
		
		int kategorija = Integer.parseInt(category.substring(1, category.length()-1));
		int t = Integer.parseInt(type.substring(1, type.length()-1));
		Tip tip = Tip.values()[t];
		
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String splitted[] = dateFrom.substring(1, dateFrom.length()-1).split(",");
		String godinaDolaska = splitted[0].split(":")[1];
		String mesecDolaska = splitted[1].split(":")[1];
		if(mesecDolaska.length()==1)
			mesecDolaska = "0" + mesecDolaska;
		String danDolaska = splitted[2].split(":")[1];
		if(danDolaska.length()==1)
			danDolaska = "0" + danDolaska;
		String datumDolaskaStr = godinaDolaska+"-"+mesecDolaska+"-"+danDolaska;
		
		String splitted2[] = dateTo.substring(1, dateTo.length()-1).split(",");
		String godinaOdlaska = splitted2[0].split(":")[1];
		String mesecOdlaska = splitted2[1].split(":")[1];
		if(mesecOdlaska.length()==1)
			mesecOdlaska = "0" + mesecOdlaska;
		String danOdlaska = splitted2[2].split(":")[1];
		if(danOdlaska.length()==1)
			danOdlaska = "0" + danOdlaska;
		String datumOdlaskaStr = godinaOdlaska+"-"+mesecOdlaska+"-"+danOdlaska;
		
		XMLGregorianCalendar datumDolaska = DatatypeFactory.newInstance().newXMLGregorianCalendar(datumDolaskaStr);
		XMLGregorianCalendar datumOdlaska = DatatypeFactory.newInstance().newXMLGregorianCalendar(datumOdlaskaStr);
            
        
    	List<Smestaj> smestaji = smestajService.getSmestajbyMesto(place.substring(1, place.length()-1));
//    	List<Smestaj> smestaji = smestajService.getSmestajbyMoreAttributes(place, kategorija, tip, parking, wifi, breakfast, half_board, board, TV, kitchen, bathroom);
		System.out.println("broj smestaja napredni search: " + smestaji.size());
    	
    	
        List<Smestaj> trazeniSmestaji = new ArrayList<Smestaj>();
        
        for(Smestaj smestaj : smestaji) {
        	if(smestaj.getKategorija()==kategorija && smestaj.getTip()==tip && smestaj.isPansion()==parking
        			&& smestaj.isWifi()==wifi && (smestaj.isDorucak()==breakfast || smestaj.isPolupansion()==half_board
        			|| smestaj.isPansion()==board) && smestaj.isTv()==TV && smestaj.isMiniKuhinja()==kitchen && smestaj.isPrivatnoKupatilo()==bathroom) {
        		
				for(Soba soba : smestaj.getSobe()) {
					if(soba.getKapacitet()==brojOsoba && (cenaOd<=soba.getCena() && soba.getCena()<=cenaDo)) {
						
						if(soba.getRezervacije().isEmpty()) {		// soba nikada nije rezervisana do sad
							if(!trazeniSmestaji.contains(smestaj)) {
								trazeniSmestaji.add(smestaj);
								continue;
							}
						}
						
						boolean slobodna = true;
						for(Rezervacija rez : soba.getRezervacije()) {
							
							if(isBetween(datumDolaska, rez.getOd(), rez.getDo()) || isBetween(datumOdlaska, rez.getOd(), rez.getDo())) {
								System.out.println("soba "+soba.getBroj()+" je zauzeta tada..");
								slobodna = false;
								break;
							}	
				
						}
						
						if(slobodna) {
							if(!trazeniSmestaji.contains(smestaj)) {
								trazeniSmestaji.add(smestaj);
							}
						}
						
					}
					
				}
				
        	}
        	
		}
		
		
		System.out.println("Broj trazenih smestaja napredni search: " + trazeniSmestaji.size());
		rezultat.setTrazeniSmestaji(trazeniSmestaji);
		
		
		return rezultat;
		
	}
	
	
	
	public boolean isBetween(XMLGregorianCalendar date,
	        XMLGregorianCalendar start, XMLGregorianCalendar end) {
	    return (date.compare(start) == DatatypeConstants.GREATER || date
	            .compare(start) == DatatypeConstants.EQUAL)
	            && (date.compare(end) == DatatypeConstants.LESSER || date
	                    .compare(end) == DatatypeConstants.EQUAL);
	}
	
	@RequestMapping(
			value = "/ratingSearch/{rejting}",
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public RezultatPretrageDTO ratingSearch(@PathVariable("rejting") String rejting) {
		double rejtingInt=Double.parseDouble(rejting);
		List<Smestaj> trazeniSmestaji=smestajService.getSmestajbyRejting(rejtingInt);
		RezultatPretrageDTO rezultat=new RezultatPretrageDTO();
		rezultat.setGreska(false);
		rezultat.setTrazeniSmestaji(trazeniSmestaji);
		return rezultat;
	}
}
