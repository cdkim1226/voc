package com.test.voc.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.voc.dto.QVocQueryDto;
import com.test.voc.dto.VocQueryDto;
import com.test.voc.entity.Order;
import com.test.voc.entity.Voc;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.test.voc.entity.QOrder.*;
import static com.test.voc.entity.QVoc.voc;

@Repository
public class VocRepository {

    private final EntityManager em;
    private final JPAQueryFactory query;

    public VocRepository(EntityManager em) {
        this.em =em;
        this.query = new JPAQueryFactory(em);
    }


    public List<VocQueryDto> findVocDto() {
        return query
                .select(new QVocQueryDto(
                        voc.id.as("vocSeq"),
                        order.id.as("order_seq"),
                        order.orderNum,
                        voc.vocResponsibility,
                        voc.vocNote,
                        voc.regDate
                ))
                .from(voc)
                .leftJoin(voc.order, order)
                .fetch();
    }

    private BooleanExpression orderNumEq(String orderNum) {
        return StringUtils.hasText(orderNum) ? order.orderNum.eq(orderNum) : null;
    }

    public void save(Voc voc) {
        em.persist(voc);
    }

    public Order findOne(Long orderSeq) {
        return em.find(Order.class, orderSeq);
    }
}
