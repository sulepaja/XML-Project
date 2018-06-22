//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 12:15:14 AM CEST 
//


package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * <p>Java class for soba complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="soba">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rezervacije" type="{http://techprimers.com/demo}rezervacija" maxOccurs="unbounded"/>
 *         &lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="kapacitet" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_smestaja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "soba", propOrder = {
    "rezervacije",
    "cena",
    "id",
    "broj",
    "kapacitet",
    "idSmestaja"
})
@Document(collection="Sobe")
public class Soba {

    @XmlElement(required = true)
    protected List<Rezervacija> rezervacije;
    protected int cena;
    
    @XmlElement(required = true)
    @Id
    protected String id;
    @XmlElement(required = true)
    protected int broj;
    @XmlElement(required = true)
    protected int kapacitet;
    @XmlElement(name = "id_smestaja", required = true)
    protected String idSmestaja;

    /**
     * Gets the value of the rezervacije property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rezervacije property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRezervacije().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rezervacija }
     * 
     * 
     */
    public List<Rezervacija> getRezervacije() {
        if (rezervacije == null) {
            rezervacije = new ArrayList<Rezervacija>();
        }
        return this.rezervacije;
    }

    /**
     * Gets the value of the cena property.
     * 
     */
    public int getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     */
    public void setCena(int value) {
        this.cena = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the broj property.
     * 
     */
    public int getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     */
    public void setBroj(int value) {
        this.broj = value;
    }

    /**
     * Gets the value of the kapacitet property.
     * 
     */
    public int getKapacitet() {
        return kapacitet;
    }

    /**
     * Sets the value of the kapacitet property.
     * 
     */
    public void setKapacitet(int value) {
        this.kapacitet = value;
    }

    /**
     * Gets the value of the idSmestaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSmestaja() {
        return idSmestaja;
    }

    /**
     * Sets the value of the idSmestaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSmestaja(String value) {
        this.idSmestaja = value;
    }

    
	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public Soba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Soba(List<Rezervacija> rezervacije, int cena, int broj, int kapacitet, String idSmestaja) {
		super();
		this.rezervacije = rezervacije;
		this.cena = cena;
		this.broj = broj;
		this.kapacitet = kapacitet;
		this.idSmestaja = idSmestaja;
	}
    
	
	
    

}
