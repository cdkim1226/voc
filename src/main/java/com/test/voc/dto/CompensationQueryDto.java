package com.test.voc.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

// 조회용 DTO
@Data
public class CompensationQueryDto {

    private Long compensationSeq;
    private Long vocSeq;
    private Long orderSeq;
    private int sellerCost;
    private int manufacturingCost;
    private int deliveryCost;
    private int compensateExpense;
    private LocalDateTime regDate;

    @QueryProjection
    public CompensationQueryDto(Long compensationSeq, Long vocSeq, Long orderSeq, int sellerCost, int manufacturingCost, int deliveryCost, int compensateExpense, LocalDateTime regDate) {
        this.compensationSeq = compensationSeq;
        this.vocSeq = vocSeq;
        this.orderSeq = orderSeq;
        this.sellerCost = sellerCost;
        this.manufacturingCost = manufacturingCost;
        this.deliveryCost = deliveryCost;
        this.compensateExpense = compensateExpense;
        this.regDate = regDate;
    }
}
