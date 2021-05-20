package com.test.voc.entity;

import com.test.voc.entity.Voc;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "order_tb")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_seq")
    private Long id;

    private String orderNum;

    private LocalDateTime regDate;

}
