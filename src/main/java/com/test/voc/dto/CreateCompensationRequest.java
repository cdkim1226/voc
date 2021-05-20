package com.test.voc.dto;

import lombok.Data;

@Data
public class CreateCompensationRequest {

    private Long vocSeq;
    private int sellerCost;
    private int manufacturingCost;
    private int deliveryCost;
    private int compensateExpense;
}
