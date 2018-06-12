//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.12 at 01:29:48 AM CEST 
//


package com.example.demo.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="broj" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="kapacitet" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="slobodna" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "soba")
@Document(collection="Sobe")
public class Soba {

	@Id
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "broj")
    protected Integer broj;
    @XmlAttribute(name = "kapacitet")
    protected Integer kapacitet;
    @XmlAttribute(name = "slobodna")
    protected Boolean slobodna;

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
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBroj() {
        return broj;
    }

    /**
     * Sets the value of the broj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBroj(Integer value) {
        this.broj = value;
    }

    /**
     * Gets the value of the kapacitet property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKapacitet() {
        return kapacitet;
    }

    /**
     * Sets the value of the kapacitet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKapacitet(Integer value) {
        this.kapacitet = value;
    }

    /**
     * Gets the value of the slobodna property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSlobodna() {
        return slobodna;
    }

    /**
     * Sets the value of the slobodna property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSlobodna(Boolean value) {
        this.slobodna = value;
    }

	public Soba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Soba(Integer broj, Integer kapacitet, Boolean slobodna) {
		super();
		this.broj = broj;
		this.kapacitet = kapacitet;
		this.slobodna = slobodna;
	}

    
    
    
    
}
