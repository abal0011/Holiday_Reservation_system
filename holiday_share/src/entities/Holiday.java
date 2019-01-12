/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Aravind
 */
@Entity
@Table(name="Holiday")
@NamedQueries({
    @NamedQuery(name = Holiday.GET_ALL_QUERY_NAME, query = "SELECT h FROM Holiday h")})
public class Holiday implements Serializable {
    
     public static final String GET_ALL_QUERY_NAME = "Holiday.getAll";
     
   
    public int transNo;
    public String transName;
    public String transType;
    public String description;
   
    public SystemUser userName;

    @ManyToOne
    public SystemUser getUser() {
        return userName;
    }

    public void setUser(SystemUser userName) {
        this.userName = userName;
    }

    public void setTransNo(int transNo) {
        this.transNo = transNo;
    }



    public Holiday() {
        
    }

 
      @Id   
      @GeneratedValue 
    public int getTransNo() {
        return transNo;
    }
    @Column(name="transName")
    public String getTransName() {
        return transName;
    }
    
    public void setTransName(String transName) {
        this.transName = transName;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Holiday(int transNo, String transName, String transType, String description, SystemUser userName) {
        this.transNo = transNo;
        this.transName = transName;
        this.transType = transType;
        this.description = description;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Holiday{" + "transNo=" + transNo + ", transName=" + transName + ", transType=" + transType + ", description=" + description + '}';
    }
    
    
}
