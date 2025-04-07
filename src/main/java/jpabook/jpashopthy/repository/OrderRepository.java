package jpabook.jpashopthy.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashopthy.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class, id);
    }

    /**
     * 주문 검색 기능 추후 개발 예정
     */
//    public List<Order> findAll(OrderSearch orderSearch){}


}
