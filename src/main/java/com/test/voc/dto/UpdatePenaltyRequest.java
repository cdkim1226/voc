package com.test.voc.dto;

import com.test.voc.entity.PenaltyStatus;
import lombok.Data;

@Data
public class UpdatePenaltyRequest {

    private PenaltyStatus penaltyStatus;
}
