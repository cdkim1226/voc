package com.test.voc.dto;

import lombok.Data;

@Data
public class CreateCompensationResponse {

    private Long id;

    public CreateCompensationResponse(Long id) {
        this.id = id;
    }
}
