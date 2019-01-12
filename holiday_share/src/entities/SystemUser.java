/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.*;

/**
 *
 * @author Aravind
 */

@Entity
@Table(name="SystemUser")
@NamedQueries({
    @NamedQuery(name = SystemUser.GET_ALL_QUERY_NAME, query = "SELECT p FROM SystemUser p")})
public class SystemUser implements Serializable {

    public static final String GET_ALL_QUERY_NAME = "SystemUser.getAll";
   
   public int id;

    public void setId(int id) {
        this.id = id;
    }
   public String firstName;
   public String lastName;  
   public String email;
   public String password;
   public String userType;
   
   public Address address;
   public String phoneNo;
   
   public Set<Holiday> holiday;

   @OneToMany(mappedBy = "userName", fetch=FetchType.LAZY, cascade=CascadeType.REMOVE) 
   public Set<Holiday> getHoliday() {
        return holiday;
    }

    public void setHoliday(Set<Holiday> holiday) {
        this.holiday = holiday;
    }
           
   
   public SystemUser() {
    }

    public SystemUser(int id, String firstName, String lastName, String email, String password, String userType, Address address, String phoneNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.address = address;
        this.phoneNo = phoneNo;
    }
    
    @Id 
    @GeneratedValue
    @Column(name="SysUserID")
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    @Embedded
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    @Override
    public String toString() {
        return "SystemUser{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", userType=" + userType + ", address=" + address + ", phoneNo=" + phoneNo + '}';
    }
  
}
