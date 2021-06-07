package com.condomeasy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "senha", updatable = false)
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
    private LocalDateTime registrationDate;

    @Column(name = "data_ultima_atualizacao")
    private LocalDateTime lastUpdateDate;

    @Column(name = "data_ultimo_login")
    private LocalDateTime lastloginDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "perfil_id", referencedColumnName = "id", nullable = false)
    @Builder.Default
    private Profile profile = new Profile();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "condominio_id", referencedColumnName = "id", nullable = false)
    @Builder.Default
    private Condominium condominium = new Condominium();

}