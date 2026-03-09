package com.luizcrisanto.orderapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
public class ItemRequestDTO {

    @NotBlank(message = "idItem é obrigatório")
    private String idItem;

    @NotNull(message = "quantidadeItem é obrigatório")
    private Integer quantidadeItem;

    @NotNull(message = "valorItem é obrigatório")
    private BigDecimal valorItem;
}