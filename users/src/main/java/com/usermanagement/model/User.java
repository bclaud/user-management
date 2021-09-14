package com.usermanagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
    private String surname;
    private String address;
    private Long securityCode;

    public User () {
    }

    public User( String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public User( String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public User ( Long id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public User ( Long id, String name, String surname, long securityCode){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.securityCode = securityCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Long getSecurityCode(){
        return securityCode;
    }

    public void setSecurityCode(Long securityCode){
        this.securityCode = securityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
