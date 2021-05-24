package com.test.voc.service;

import com.test.voc.entity.*;
import com.test.voc.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PenaltyService {

    private final PenaltyRepository penaltyRepository;

    public Compensation findOneCompensation(Long compensationSeq) {
        return penaltyRepository.findOneCompensation(compensationSeq);
    }

    public Manager findOneManager(Long managerSeq) {
        return penaltyRepository.findOneManager(managerSeq);
    }

    @Transactional
    public Long savePenalty(Penalty penalty) {
        penaltyRepository.save(penalty);
        return penalty.getId();
    }

    public Penalty findOne(Long penaltySeq) {
        return penaltyRepository.findOne(penaltySeq);
    }

    @Transactional
    public void update(Long id, PenaltyStatus penaltyStatus, String penaltyContents, VocStatus vocStatus) {
        Penalty penalty = penaltyRepository.findOne(id);
        penalty.setPenaltyStatus(penaltyStatus);
        penalty.setPenaltyContents(penaltyContents);
        Voc voc = new Voc();
        voc.setVocStatus(vocStatus);
    }
}
