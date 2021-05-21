package com.test.voc.dto;

import com.test.voc.entity.PenaltyStatus;
import lombok.Data;

@Data
public class CreatePenaltyRequest {

    private Long compensationSeq;
    private Long managerSeq;
    private int penaltyExpense;
    private String penaltyContents;
}
