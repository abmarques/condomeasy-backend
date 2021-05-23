package com.condomeasy.backend.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@Table(name = "tb_usuario")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "usuario")
    private String username;

    @Column(name = "senha")
    private String password;

    @Column(name = "sobrenome")
    private String surname;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id", nullable = false)
    private Profile profile;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condominio_id", referencedColumnName = "id", nullable = false)
    private Condominium condominium;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Advertisement> advertisements;

}