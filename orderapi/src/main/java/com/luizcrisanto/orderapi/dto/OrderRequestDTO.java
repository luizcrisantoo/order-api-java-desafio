package com.luizcrisanto.orderapi.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {

    @NotBlank(message = "numeroPedido é obrigatório")
    private String numeroPedido;

    @NotNull(message = "valorTotal é obrigatório")
    private BigDecimal valorTotal;

    @NotNull(message = "dataCriacao é obrigatória")
    private OffsetDateTime dataCriacao;

    @Valid
    @NotEmpty(message = "items não pode ser vazio")
    private List<ItemRequestDTO> items;
}
