package com.example.grocery;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String fristName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
    private String creditCardId;

    public User(String fn, String ln, String add, String phone, String email, String password, String cc){
        this.fristName = fn;
        this.lastName= ln;
        this.address = add;
        this.phoneNumber = phone;
        this.email= email;
        this.password= password;
        this.creditCardId = cc;
    }
}

