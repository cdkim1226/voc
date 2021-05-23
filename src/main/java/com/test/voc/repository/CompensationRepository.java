package com.test.voc.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.voc.dto.CompensationQueryDto;
import com.test.voc.dto.QCompensationQueryDto;
import com.test.voc.entity.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static com.test.voc.entity.QCompensation.*;
import static com.test.voc.entity.QOrder.*;
import static com.test.voc.entity.QVoc.*;

@Repository
public class CompensationRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public CompensationRepository(EntityManager em) {
        this.em =em;
        this.query = new JPAQueryFactory(em);
    }

    public List<CompensationQueryDto> findCompensationDto() {
        return query
                .select(new QCompensationQueryDto(
                        compensation.id.as("compensationSeq"),
                        voc.id.as("vocSeq"),
                        voc.order.id.as("orderSeq"),
                        compensation.sellerCost,
                        compensation.manufacturingCost,
                        compensation.deliveryCost,
                        compensation.compensateExpense,
                        compensation.regDate
                ))
                .from(compensation)
                .leftJoin(compensation.voc, voc)
                .fetch();
    }

    public Voc findOne(Long vocSeq) {
        return em.find(Voc.class, vocSeq);
    }

    public void save(Compensation compensation) {
        em.persist(compensation);
    }
}
