package com.test.voc.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VocQueryDto {

    private Long vocSeq;
    private Long orderSeq;
    private String orderNum;
    private String vocResponsibility;
    private String vocNote;
    private LocalDateTime regDate;

    @QueryProjection
    public VocQueryDto(Long vocSeq,Long orderSeq, String orderNUm, String vocResponsibility, String vocNote, LocalDateTime regDate) {

        this.vocSeq = vocSeq;
        this.orderSeq = orderSeq;
        this.orderNum = orderNUm;
        this.vocResponsibility = vocResponsibility;
        this.vocNote = vocNote;
        this.regDate = regDate;
    }
}
