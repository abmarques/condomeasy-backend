package com.condomeasy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "logradouro")
    private String adress;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "numero")
    private Integer number;

    @Column(name = "bairro")
    private String neighborhood;

    @Column(name = "cidade")
    private String city;

    @Column(name = "uf")
    private String uf;

    @Column(name = "localizacao_x")
    private String localizationX;

    @Column(name = "localizacao_y")
    private String localizationY;

}