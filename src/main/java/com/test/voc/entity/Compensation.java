package com.test.voc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "compensation_tb")
@Getter @Setter
public class Compensation {

    @Id @GeneratedValue
    @Column(name = "compensation_seq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "voc_seq")
    private Voc voc;


    private int sellerCost;
    private int manufacturingCost;
    private int deliveryCost;
    private int compensateExpense;
    private LocalDateTime regDate;

}
