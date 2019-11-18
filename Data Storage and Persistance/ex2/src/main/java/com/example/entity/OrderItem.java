package com.example.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="orderitems")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @Column(name = "order_item_name")
    private String itemName;

    @Column(name = "order_item_count")
    private int itemCount;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
}
