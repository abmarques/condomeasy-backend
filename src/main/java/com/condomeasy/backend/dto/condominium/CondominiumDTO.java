package com.condomeasy.backend.dto.condominium;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CondominiumDTO {

    private Integer id;

    private String name;

    private String cnpj;

    private String adress;

    private String complement;

    private Integer number;

    private String neighborhood;

    private String city;

    private String uf;

    private String localizationX;

    private String localizationY;

}
