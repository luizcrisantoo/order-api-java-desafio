package com.luizcrisanto.orderapi.service;

import com.luizcrisanto.orderapi.dto.ItemRequestDTO;
import com.luizcrisanto.orderapi.dto.ItemResponseDTO;
import com.luizcrisanto.orderapi.dto.OrderRequestDTO;
import com.luizcrisanto.orderapi.dto.OrderResponseDTO;
import com.luizcrisanto.orderapi.entity.Item;
import com.luizcrisanto.orderapi.entity.Order;
import com.luizcrisanto.orderapi.repository.OrderRepository;
import com.luizcrisanto.orderapi.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderResponseDTO createOrder(OrderRequestDTO dto) {
        Order order = new Order();
        order.setOrderId(extractOrderId(dto.getNumeroPedido()));
        order.setValue(dto.getValorTotal());
        order.setCreationDate(dto.getDataCriacao());

        List<Item> items = dto.getItems().stream().map(itemDto -> {
            Item item = new Item();
            item.setProductId(Long.parseLong(itemDto.getIdItem()));
            item.setQuantity(itemDto.getQuantidadeItem());
            item.setPrice(itemDto.getValorItem());
            item.setOrder(order);
            return item;
        }).toList();

        order.setItems(items);

        Order savedOrder = orderRepository.save(order);

        return toResponseDTO(savedOrder);
    }

    private String extractOrderId(String numeroPedido) {
        int index = numeroPedido.lastIndexOf("-");
        if (index != -1) {
            return numeroPedido.substring(0, index);
        }
        return numeroPedido;
    }

    private OrderResponseDTO toResponseDTO(Order order) {
        List<ItemResponseDTO> items = order.getItems().stream()
                .map(item -> new ItemResponseDTO(
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()
                ))
                .toList();

        return new OrderResponseDTO(
                order.getOrderId(),
                order.getValue(),
                order.getCreationDate(),
                items
        );
    }

    public OrderResponseDTO getOrderById(String orderId) {
    Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new ResourceNotFoundException("Pedido não encontrado com id: " + orderId));

    return toResponseDTO(order);
    }

    public List<OrderResponseDTO> listOrders() {
    return orderRepository.findAll()
            .stream()
            .map(this::toResponseDTO)
            .toList();
    }
}