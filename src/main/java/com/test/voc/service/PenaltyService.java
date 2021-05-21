package com.test.voc.service;

import com.test.voc.entity.Compensation;
import com.test.voc.entity.Manager;
import com.test.voc.entity.Penalty;
import com.test.voc.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PenaltyService {

    private final PenaltyRepository penaltyRepository;

    public Compensation findOne(Long compensationSeq) {
        return penaltyRepository.findOne(compensationSeq);
    }

//    public Manager findOne(Long managerSeq) {
//        return penaltyRepository.findOne(managerSeq);
//    }

    @Transactional
    public Long savePenalty(Penalty penalty) {
        penaltyRepository.save(penalty);
        return penalty.getId();
    }
}
