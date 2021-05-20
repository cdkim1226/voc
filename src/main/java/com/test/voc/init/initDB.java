package com.test.voc.init;

import com.test.voc.entity.Customer;
import com.test.voc.entity.Manager;
import com.test.voc.entity.Order;
import com.test.voc.entity.Voc;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class initDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class InitService {

        private final EntityManager em;

        public void init() {
            Order order1 = createOrder("111-1111");
            em.persist(order1);
            Order order2 = createOrder("222-2222");
            em.persist(order2);

            Voc voc1 = createVoc("매니저", "오배송",order1);
            em.persist(voc1);

        }

        private Order createOrder(String orderNum) {
            Order order = new Order();
            order.setOrderNum(orderNum);
            order.setRegDate(LocalDateTime.now());
            return order;
        }

        private Customer createCustomer(String customerName) {
            Customer customer = new Customer();
            customer.setCustomerName(customerName);
            return customer;
        }

        private Manager createManager(String managerName) {
            Manager manager = new Manager();
            manager.setManagerName(managerName);
            return manager;
        }

        private Voc createVoc(String vocResponsibility, String vocNote, Order order) {
            Voc voc = new Voc();
            voc.setOrder(order);
            voc.setVocResponsibility(vocResponsibility);
            voc.setVocNote(vocNote);
            voc.setRegDate(LocalDateTime.now());
            return voc;
        }
    }

}
