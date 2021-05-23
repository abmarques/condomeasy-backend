package com.condomeasy.backend.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "tb_anuncio")
public class Advertisement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "descricao")
    private String description;

    @Column(name = "valor")
    private BigDecimal value;

    @ManyToOne()
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private User user;

}
