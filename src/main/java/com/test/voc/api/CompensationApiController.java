package com.test.voc.api;

import com.test.voc.dto.CompensationQueryDto;
import com.test.voc.dto.CreateCompensationRequest;
import com.test.voc.dto.CreateCompensationResponse;
import com.test.voc.entity.Compensation;
import com.test.voc.service.CompensationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompensationApiController {

    private final CompensationService compensationService;


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


    @GetMapping("/api/compensation")
    public List<CompensationQueryDto> compensationList() {
        return compensationService.findCompensationDto();
    }

}
