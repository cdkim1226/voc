package com.test.voc.api;

import com.test.voc.dto.*;
import com.test.voc.entity.Compensation;
import com.test.voc.entity.Penalty;
import com.test.voc.entity.Voc;
import com.test.voc.service.CompensationService;
import com.test.voc.service.PenaltyService;
import com.test.voc.service.VocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VocCompensationApiController {

    private final VocService vocService;
    private final CompensationService compensationService;
    private final PenaltyService penaltyService;

    // voc 등록
    @PostMapping("/api/insertVoc")
    public CreateVocResponse saveVoc(@RequestBody @Valid CreateVocRequest request) {

        Voc voc = new Voc();
        voc.setVocResponsibility(request.getVocResponsibility());
        voc.setVocNote(request.getVocNote());
        voc.setOrder(vocService.findOne(request.getOrderSeq()));
        voc.setRegDate(LocalDateTime.now());
        Long id = vocService.saveVoc(voc);
        return new CreateVocResponse(id);
    }

    // voc 조회
    @GetMapping("/api/voc")
    public List<VocQueryDto> vocList() {
        return vocService.findVocDto();
    }

    // 배상 등록
    @PostMapping("/api/insertCompensation")
    public CreateCompensationResponse saveCompensation(@RequestBody @Valid CreateCompensationRequest request) {

        Compensation compensation = new Compensation();
        compensation.setSellerCost(request.getSellerCost());
        compensation.setManufacturingCost(request.getManufacturingCost());
        compensation.setDeliveryCost(request.getDeliveryCost());
        compensation.setCompensateExpense(request.getCompensateExpense());
        compensation.setVoc(compensationService.findOne(request.getVocSeq()));
        compensation.setRegDate(LocalDateTime.now());
        Long id = compensationService.saveCompensation(compensation);
        return new CreateCompensationResponse(id);

    }

    // 배상 조회
    @GetMapping("/api/compensation")
    public List<CompensationQueryDto> compensationList() {
        return compensationService.findCompensationDto();
    }

    // 패널티 등록
    @PostMapping("/api/insertPenalty")
    public CreatePenaltyResponse savePenalty(@RequestBody @Valid CreatePenaltyRequest request) {

        Penalty penalty = new Penalty();
        penalty.setCompensation(penaltyService.findOne(request.getCompensationSeq()));
//        penalty.setManager(request.getManagerSeq());
//        penalty.setManager(penaltyService.findOne(request.getManagerSeq()));
        penalty.setPenaltyExpense(request.getPenaltyExpense());
        penalty.setPenaltyContents(request.getPenaltyContents());
        penalty.setRegDate(LocalDateTime.now());
        Long id = penaltyService.savePenalty(penalty);
        return new CreatePenaltyResponse(id);
    }
}
