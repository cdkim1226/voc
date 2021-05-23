package com.test.voc.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.voc.entity.Compensation;
import com.test.voc.entity.Manager;
import com.test.voc.entity.Penalty;
import com.test.voc.entity.Voc;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PenaltyRepository {


    private final EntityManager em;
    private final JPAQueryFactory query;

    public PenaltyRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    public Compensation findOneCompensation(Long compensationSeq) {
        return em.find(Compensation.class, compensationSeq);
    }

    public Manager findOneManager(Long managerSeq) {
        return em.find(Manager.class, managerSeq);
    }

    public void save(Penalty penalty) {
        em.persist(penalty);
    }

}
