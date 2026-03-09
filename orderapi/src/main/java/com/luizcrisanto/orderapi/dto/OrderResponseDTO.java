package com.luizcrisanto.orderapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponseDTO {
    private String orderId;
    private BigDecimal value;
    private OffsetDateTime creationDate;
    private List<ItemResponseDTO> items;
}