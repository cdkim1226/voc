package com.test.voc.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "penalty_tb")
@Getter @Setter
public class Penalty {

    @Id @GeneratedValue
    @Column(name = "penaltySeq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "manager_seq")
    private Manager manager;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "compensation_seq")
    private Compensation compensation;

    private int penaltyExpense;
    private PenaltyStatus penaltyStatus; // 0패널티등록상태, 1매니저서명, 2이의제기
    private String penaltyContents;
    private LocalDateTime regDate;

}
