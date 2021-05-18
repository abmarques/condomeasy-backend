package com.condomeasy.backend.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "tb_perfil")
public class Perfil {

    @javax.persistence.Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    @Column(name = "nome")
    private String Nome;
}