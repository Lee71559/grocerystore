package com.example.springpayments;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="Payments")
@Data
@RequiredArgsConstructor
public class PaymentsCommand {

    private @Id @GeneratedValue Long id;

    //transient private String action ;
    private String firstname ;
    private String lastname ;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String cardnum;
    private String cardexpmon;
    private String cardexpyear;
    private String cardcvv;
    private String email;
    private String notes;

    private String orderNumber;
    private String transactionAmount;
    private String transactionCurrency;
    private String authId;
    private String authStatus;
    private String captureId;
    private String captureStatus;

    public boolean error;



    public PaymentsCommand(String firstname, 
        String lastname, 
        String address, 
        String city, 
        String state, 
        String zip, 
        String phone,
        String cardnum,
        String cardcvv,
        String cardexpyear,
        String cardexpmon,
        String email,
        String notes
        ) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.address= address;
        this.city = city;
        this.state=state;
        this.zip = zip;
        this.phone = phone;
        this.cardnum = cardnum;
        this.cardexpmon = cardexpmon;
        this.cardexpyear = cardexpyear;
        this.cardcvv = cardcvv;
        this.email = email;
        this.notes = notes;
    }


    public String firstname() {return firstname;}
    public String lastname() {return lastname;}
    public String address() {return city;}
    public String city() {return city;}
    public String state() {return state;}
    public String zip() {return zip;}
    public String phone() {return phone;}
    public String cardnum() {return cardnum;}
    public String cardexpmon() {return cardexpmon;}
    public String cardexpyear() {return cardexpyear;}
    public String cardcvv() {return cardcvv;}
    public String email() {return email;}
    public String notes() {return notes;}


  
    
}
