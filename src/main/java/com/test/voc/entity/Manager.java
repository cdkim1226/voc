package com.test.voc.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manager_tb")
@Getter @Setter
public class Manager {

    @Id @GeneratedValue
    @Column(name = "manager_seq")
    private Long id;

    private String managerName;
}
