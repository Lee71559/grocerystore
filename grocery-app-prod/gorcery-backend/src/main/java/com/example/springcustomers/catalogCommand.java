package com.example.springcustomers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Data
@NoArgsConstructor
public class catalogCommand {

    private int itemId;
    private int quantity;

}

