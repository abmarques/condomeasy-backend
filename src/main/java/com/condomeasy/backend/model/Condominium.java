package com.condomeasy.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_condominio")
public class Condominium {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Integer id;

    @Column(name = "nome")
    @JsonProperty("name")
    private String name;

    @Column(name = "cnpj")
    @JsonProperty("cnpj")
    private String cnpj;

    @Column(name = "logradouro")
    @JsonProperty("adress")
    private String adress;

    @Column(name = "complemento")
    @JsonProperty("complement")
    private String complement;

    @Column(name = "numero")
    @JsonProperty("number")
    private Integer number;

    @Column(name = "bairro")
    @JsonProperty("neighborhood")
    private String neighborhood;

    @Column(name = "cidade")
    @JsonProperty("city")
    private String city;

    @Column(name = "uf")
    @JsonProperty("uf")
    private String uf;

    @Column(name = "localizacao_x")
    @JsonProperty("localizationX")
    private String localizationX;

    @Column(name = "localizacao_y")
    @JsonProperty("localizationY")
    private String localizationY;

}