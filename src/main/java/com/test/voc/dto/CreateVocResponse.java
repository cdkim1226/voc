package com.test.voc.dto;

import lombok.Data;

@Data
public class CreateVocResponse {
    private Long id;

    public CreateVocResponse(Long id) {
        this.id = id;
    }
}