package com.condomeasy.backend.dto;

import com.condomeasy.backend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementDTO {

    private Integer id;

    @NotEmpty(message = "Informe o nome do anúncio.")
    private String name;

    @NotEmpty(message = "Informe a descrição do anúncio.")
    private String description;

    @NotNull(message = "Informe o valor do anúncio.")
    private BigDecimal value;

    @NotNull(message = "Informe a categoria do anúncio.")
    private Category category;

    @NotNull(message = "Informe o id do usuário do anúncio.")
    private Integer userId;

}
