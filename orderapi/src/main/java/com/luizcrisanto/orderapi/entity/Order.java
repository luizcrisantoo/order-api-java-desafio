package com.luizcrisanto.orderapi.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "creation_date")
    private OffsetDateTime creationDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> items;
}