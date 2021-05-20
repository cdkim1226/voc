package com.test.voc.api;

import com.test.voc.dto.VocQueryDto;
import com.test.voc.entity.Order;
import com.test.voc.entity.Voc;
import com.test.voc.repository.VocRepository;
import com.test.voc.service.VocService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class VocApiController {

    private final VocRepository vocRepository;
    private final VocService vocService;


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

    @GetMapping("/api/voc")
    public List<VocQueryDto> vocList() {
        return vocRepository.findVocDto();
    }

    @Data
    static class CreateVocRequest {
        private String vocResponsibility;
        private String vocNote;
        private Long orderSeq;
    }

    @Data
    static class CreateVocResponse {
        private Long id;

        public CreateVocResponse(Long id) {
            this.id = id;
        }
    }


}
