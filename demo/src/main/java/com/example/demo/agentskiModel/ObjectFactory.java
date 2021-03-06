
package com.example.demo.agentskiModel;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.w3._2001.xmlschema.agent package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.w3._2001.xmlschema.agent
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSmestajRequest }
     * 
     */
    public GetSmestajRequest createGetSmestajRequest() {
        return new GetSmestajRequest();
    }

    /**
     * Create an instance of {@link GetSmestajResponse }
     * 
     */
    public GetSmestajResponse createGetSmestajResponse() {
        return new GetSmestajResponse();
    }

    /**
     * Create an instance of {@link Smestaj }
     * 
     */
    public Smestaj createSmestaj() {
        return new Smestaj();
    }

    /**
     * Create an instance of {@link Soba }
     * 
     */
    public Soba createSoba() {
        return new Soba();
    }

    /**
     * Create an instance of {@link Korisnik }
     * 
     */
    public Korisnik createKorisnik() {
        return new Korisnik();
    }

    /**
     * Create an instance of {@link Recenzija }
     * 
     */
    public Recenzija createRecenzija() {
        return new Recenzija();
    }

    /**
     * Create an instance of {@link Komentar }
     * 
     */
    public Komentar createKomentar() {
        return new Komentar();
    }

    /**
     * Create an instance of {@link Rezervacija }
     * 
     */
    public Rezervacija createRezervacija() {
        return new Rezervacija();
    }

    /**
     * Create an instance of {@link Poruka }
     * 
     */
    public Poruka createPoruka() {
        return new Poruka();
    }

}
