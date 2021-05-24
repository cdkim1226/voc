package com.test.voc.dto;

import com.test.voc.entity.PenaltyStatus;
import com.test.voc.entity.VocStatus;
import lombok.Data;

@Data
public class UpdatePenaltyRequest {

    private String penaltyContents;
    private PenaltyStatus penaltyStatus;
    private VocStatus vocStatus;
}
