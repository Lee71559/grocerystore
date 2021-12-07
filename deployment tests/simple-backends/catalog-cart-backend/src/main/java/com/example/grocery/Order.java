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
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name = "userId" ,unique=true, nullable = false)
    private long customerid;

    @Column(name = "paymentID" ,unique=true, nullable = false)
    private long paymentId;

    private double total;
    private String paymentStatus;
    private String deliveryStatus;
}

