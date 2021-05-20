package com.test.voc.service;

import com.test.voc.dto.CompensationQueryDto;
import com.test.voc.entity.Compensation;
import com.test.voc.entity.Voc;
import com.test.voc.repository.CompensationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompensationService {

    private final CompensationRepository compensationRepository;



    public List<CompensationQueryDto> findCompensationDto() {
        return compensationRepository.findCompensationDto();
    }

    public Voc findOne(Long vocSeq) {
        return compensationRepository.findOne(vocSeq);
    }

    @Transactional
    public Long saveCompensation(Compensation compensation) {
        compensationRepository.save(compensation);
        return compensation.getId();
    }
}
