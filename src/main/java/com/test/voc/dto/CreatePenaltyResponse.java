package com.test.voc.dto;

import lombok.Data;

@Data
public class CreatePenaltyResponse {

    private Long id;

    public CreatePenaltyResponse(Long id) {
        this.id = id;
    }
}
