package com.test.voc.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.test.voc.entity.VocStatus;
import lombok.Data;

import java.time.LocalDateTime;

// 조회용 DTO
@Data
public class VocQueryDto {

    private Long vocSeq;
    private Long orderSeq;
    private String orderNum;
    private VocStatus vocStatus;
    private String vocResponsibility;
    private String vocNote;
    private LocalDateTime regDate;

    @QueryProjection
    public VocQueryDto(Long vocSeq,Long orderSeq, String orderNUm, String vocResponsibility, String vocNote, LocalDateTime regDate) {

        this.vocSeq = vocSeq;
        this.orderSeq = orderSeq;
        this.orderNum = orderNUm;
        this.vocStatus = VocStatus.RECEPTION;
        this.vocResponsibility = vocResponsibility;
        this.vocNote = vocNote;
        this.regDate = regDate;
    }
}
