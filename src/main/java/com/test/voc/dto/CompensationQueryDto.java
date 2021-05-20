package com.test.voc.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CompensationQueryDto {

    private Long compensationSeq;
    private Long vocSeq;
    private int sellerCost;
    private int manufacturingCost;
    private int deliveryCost;
    private int compensateExpense;
    private LocalDateTime regDate;

    @QueryProjection
    public CompensationQueryDto(Long compensationSeq, Long vocSeq, int sellerCost, int manufacturingCost, int deliveryCost, int compensateExpense, LocalDateTime regDate) {
        this.compensationSeq = compensationSeq;
        this.vocSeq = vocSeq;
        this.sellerCost = sellerCost;
        this.manufacturingCost = manufacturingCost;
        this.deliveryCost = deliveryCost;
        this.compensateExpense = compensateExpense;
        this.regDate = regDate;
    }
}
