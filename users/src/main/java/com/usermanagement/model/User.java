package com.usermanagement.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String name;
    private String surname;
    private String address;
    private Long securityCode;
    
}
