package com.test.voc.dto;

import com.test.voc.entity.PenaltyStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdatePenaltyResponse {
    private Long id;
    private String penaltyContents;
    private PenaltyStatus penaltyStatus;
}
