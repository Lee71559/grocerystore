package com.example.backofficeportal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Entity 
public class Order {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String item;

  private String quantity;

  private String amount;

  private String status;

  public Order (String item, String quantity, String amount, String status) {
      this.item = item ;
      this.quantity = quantity ; 
      this.amount = amount ; 
      this.status = status ;
  }
}