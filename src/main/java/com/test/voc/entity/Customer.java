package com.test.voc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer_tb")
@Getter @Setter
public class Customer {

    @Id @GeneratedValue
    @Column(name = "customer_seq")
    private Long id;

    private String customerName;
}
