package com;

import com.example.entity.Order;
import com.example.entity.OrderItem;
import org.aspectj.weaver.ast.Or;
import org.hibernate.PersistentObjectException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Arrays;

public class OrderTest {

    private static final String PERSISTENCE_UNIT_NAME = "Order";

    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        //create a factory for the persistence unit
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

        //create an EntityManager
        EntityManager em = factory.createEntityManager();

        //Start a transaction
        em.getTransaction().begin();

        //Create an order
        Order order =  new Order();
        order.setCustomerName("Vasista");
        order.setCustomerAddress("857 Spiros Ct DeKalb IL 60115");
        order.setCredatedTime(Timestamp.valueOf(LocalDateTime.now()));

        OrderItem orderItem = new OrderItem();
        orderItem.setItemName("Parachute");
        orderItem.setItemCount(3);
        orderItem.setOrder(order);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setItemName("Hand Glider");
        orderItem1.setItemCount(3);
        orderItem1.setOrder(order);

        order.setOrderItems(Arrays.asList(orderItem, orderItem1));

        // persist the order entity
        em.persist(order);

        System.err.println("Order ID:" + order.getOrderId());
        System.err.println("Order Item 1:" + orderItem.getOrderItemId());
        System.err.println("Order Item 2:" + orderItem1.getOrderItemId());

        em.getTransaction().commit();
        em.close();

        //Example to read an entity
        readOrder(order.getOrderId(), factory);

        factory.close();
    }

    private static void readOrder(Integer orderId, EntityManagerFactory factory) {
        EntityManager entityManager = factory.createEntityManager();

        Order order = entityManager.find(Order.class, orderId);

        System.err.println("Order: " + order);
        order.getOrderItems().forEach(orderItem -> System.err.println("Order Item: " + orderItem));
        entityManager.close();
    }
}
