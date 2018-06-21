//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.22 at 12:05:56 AM CEST 
//


package com.example.agent.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * <p>Java class for rezervacija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rezervacija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="od" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="do" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="id_sobe" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id_Korisnika" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="realizacija" type="{http://techprimers.com/spring-boot-soap-example}realizacija"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rezervacija", propOrder = {
    "id",
    "od",
    "_do",
    "idSobe",
    "idKorisnika",
    "realizacija"
})
@Document(collection="Rezervacije")
public class Rezervacija {

	@Id
    @XmlElement(required = true)
    protected String id;
    public XMLGregorianCalendar get_do() {
		return _do;
	}

	public void set_do(XMLGregorianCalendar _do) {
		this._do = _do;
	}

	@XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar od;
    @XmlElement(name = "do", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar _do;
    @XmlElement(name = "id_sobe", required = true)
    protected String idSobe;
    @XmlElement(name = "id_Korisnika", required = true)
    protected String idKorisnika;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Realizacija realizacija;

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
     * Gets the value of the od property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOd() {
        return od;
    }

    /**
     * Sets the value of the od property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOd(XMLGregorianCalendar value) {
        this.od = value;
    }

    /**
     * Gets the value of the do property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDo() {
        return _do;
    }

    /**
     * Sets the value of the do property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDo(XMLGregorianCalendar value) {
        this._do = value;
    }

    /**
     * Gets the value of the idSobe property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdSobe() {
        return idSobe;
    }

    /**
     * Sets the value of the idSobe property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdSobe(String value) {
        this.idSobe = value;
    }

    /**
     * Gets the value of the idKorisnika property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdKorisnika() {
        return idKorisnika;
    }

    /**
     * Sets the value of the idKorisnika property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdKorisnika(String value) {
        this.idKorisnika = value;
    }

    /**
     * Gets the value of the realizacija property.
     * 
     * @return
     *     possible object is
     *     {@link Realizacija }
     *     
     */
    public Realizacija getRealizacija() {
        return realizacija;
    }

    /**
     * Sets the value of the realizacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Realizacija }
     *     
     */
    public void setRealizacija(Realizacija value) {
        this.realizacija = value;
    }

}
