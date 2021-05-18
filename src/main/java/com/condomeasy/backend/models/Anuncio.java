package com.condomeasy.backend.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@Table(name = "tb_anuncio")
public class Anuncio {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "nome")
    private String Nome;

    @Column(name = "descricao")
    private String Descricao;

    @Column(name = "valor")
    private BigDecimal Valor;

    @Column(name = "categoria_id")
    private Integer CategoriaId;

    @Column(name = "usuario_id")
    private Integer UsuarioId;
}
