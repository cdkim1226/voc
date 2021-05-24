package com.test.voc.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "voc_tb")
@Getter @Setter
public class Voc {

    @Id @GeneratedValue
    @Column(name = "voc_seq")
    private Long id;

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "order_seq")
    private Order order;


    private VocStatus vocStatus; // 0: voc 접수상태, 1: 매니저 서명 완료, 2: 이의제기, 3: 배상 등록
    private String vocResponsibility;
    private String vocNote;
    private LocalDateTime regDate;

}
