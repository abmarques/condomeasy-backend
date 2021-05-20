package com.condomeasy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
    private String user;

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

    @JoinColumn(name = "perfil_id", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.LAZY)
    private Profile profileId;

    @JoinColumn(name = "condominio_id", referencedColumnName = "id")
	@OneToOne(fetch = FetchType.LAZY)
    private Condominium condominiumId;

}