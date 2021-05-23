package com.condomeasy.backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "tb_categoria")
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Advertisement> advertisements;

}