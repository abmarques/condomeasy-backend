package com.condomeasy.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CondominiumDTO {

    private Integer id;

    @NotEmpty(message = "Informe o nome do condomínio.")
    private String name;

    @NotEmpty(message = "Informe o cnpj do condomínio.")
    private String cnpj;

    @NotEmpty(message = "Informe o logradouro do condomínio.")
    private String adress;

    private String complement;

    @NotNull(message = "Informe o número do condomínio.")
    private Integer number;

    @NotEmpty(message = "Informe o bairro do condomínio.")
    private String neighborhood;

    @NotEmpty(message = "Informe a cidade do condomínio.")
    private String city;

    @NotEmpty(message = "Informe o uf do condomínio.")
    private String uf;

    private String localizationX;

    private String localizationY;

}
