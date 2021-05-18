package com.condomeasy.backend.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "tb_condominio")
public class Condominio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "nome")
    private String Nome;

    @Column(name = "cnpj")
    private String Cnpj;

    @Column(name = "logradouro")
    private String Logradouro;

    @Column(name = "complemento")
    private String Complemento;

    @Column(name = "numero")
    private Integer Numero;

    @Column(name = "bairro")
    private String Bairro;

    @Column(name = "cidade")
    private String Cidade;

    @Column(name = "uf")
    private String Uf;

    @Column(name = "localizacao_x")
    private String LocalizacaoX;

    @Column(name = "localizacao_y")
    private String LocalizacaoY;
}