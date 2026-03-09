package com.luizcrisanto.orderapi.controller;

import com.luizcrisanto.orderapi.dto.OrderRequestDTO;
import com.luizcrisanto.orderapi.dto.OrderResponseDTO;
import com.luizcrisanto.orderapi.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO dto) {
        OrderResponseDTO response = orderService.createOrder(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable String orderId) {
        OrderResponseDTO response = orderService.getOrderById(orderId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderResponseDTO>> listOrders() {
        List<OrderResponseDTO> response = orderService.listOrders();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderResponseDTO> updateOrder(
            @PathVariable String orderId,
            @Valid @RequestBody OrderRequestDTO dto) {

        OrderResponseDTO response = orderService.updateOrder(orderId, dto);
        return ResponseEntity.ok(response);
    }

}
