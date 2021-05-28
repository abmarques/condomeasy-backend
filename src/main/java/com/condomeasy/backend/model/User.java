package com.condomeasy.backend.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
@DynamicUpdate
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "sobrenome")
    private String surname;

    @Column(name = "status")
    private String status;

    @Column(name = "usuario")
    private String username;

    @Column(name = "senha")
    private String password;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "telefone")
    private String telephone;

    @Column(name = "email")
    private String email;

    @Column(name = "numero_apto")
    private String apartmentNumber;

    @Column(name = "bloco_apto")
    private String apartmentBlock;

    @Column(name = "data_cadastro")
    private LocalDate registrationDate;

    @Column(name = "data_ultima_atualizacao")
    private LocalDate lastUpdateDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id", nullable = false)
    @Builder.Default
    private Profile profile = new Profile();

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "condominio_id", referencedColumnName = "id", nullable = false)
    @Builder.Default
    private Condominium condominium = new Condominium();

}