/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

/**
 *
 * @author Aravind
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address {

    public String city;
    public String country;
    public String postCode;

    public Address(String city, String country, String postCode) {
        this.city = city;
        this.country = country;
        this.postCode = postCode;
    }
    
        public Address() {
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
   
}
