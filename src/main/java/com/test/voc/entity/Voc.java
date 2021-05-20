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

    private String vocResponsibility;

    private String vocNote;

    private LocalDateTime regDate;

}
