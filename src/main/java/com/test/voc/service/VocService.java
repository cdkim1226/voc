package com.test.voc.service;

import com.test.voc.entity.Order;
import com.test.voc.entity.Voc;
import com.test.voc.repository.VocRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VocService {

    private final VocRepository vocRepository;


    public Order findOne(Long orderSeq) {
        return vocRepository.findOne(orderSeq);
    }

    @Transactional
    public Long saveVoc(Voc voc) {
        vocRepository.save(voc);
        return voc.getId();
    }

}
