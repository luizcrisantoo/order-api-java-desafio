package com.luizcrisanto.orderapi.repository;

import com.luizcrisanto.orderapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}