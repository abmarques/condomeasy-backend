package com.condomeasy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_anuncio")
public class Advertisement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "descricao")
    private String description;

    @Column(name = "valor")
    private BigDecimal value;

    @Column(name = "url_imagem")
    private String ImageUrl;

    @ManyToOne()
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    @Builder.Default
    private Category category = new Category();

    @ManyToOne()
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @Builder.Default
    private User user = new User();

}
