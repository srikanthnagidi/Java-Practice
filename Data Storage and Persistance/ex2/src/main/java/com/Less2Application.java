package com;

import com.example.entity.Order;
import com.example.entity.OrderItem;
import com.example.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories
public class Less2Application {
    private  static  final Logger log = LoggerFactory.getLogger(Less2Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Less2Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(OrderRepository orderRepository){
        return  args -> {
            Order order = new Order();
            order.setCustomerName("Srikanth");
            order.setCustomerAddress("1st Avenue, DeKalb, IL, 60115");
            order.setCredatedTime(Timestamp.valueOf(LocalDateTime.now()));

            OrderItem orderItem = new OrderItem();
            orderItem.setItemName("Pen");
            orderItem.setItemCount(3);
            orderItem.setOrder(order);

            OrderItem orderItem1 = new OrderItem();
            orderItem1.setItemName("Pencil");
            orderItem1.setItemCount(3);
            orderItem1.setOrder(order);

            order = orderRepository.save(order);
            System.err.println("Order ID: " + order.getOrderId());
            Optional<Order> orderRead = orderRepository.findByCustomerName("Srikanth");
            orderRead.ifPresent(value -> System.err.println("Order: " + value));
        };
    }
}
