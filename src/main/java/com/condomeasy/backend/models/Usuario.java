package com.condomeasy.backend.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@Table(name = "tb_usuario")
public class Usuario extends BaseModel{

    @Column(name = "status")
    private String Status;

    @Column(name = "usuario")
    private String Usuario;

    @Column(name = "senha")
    private String Senha;

    @Column(name = "sobrenome")
    private String Sobrenome;

    @Column(name = "cpf")
    private String Cpf;

    @Column(name = "telefone")
    private String Telefone;

    @Column(name = "email")
    private String Email;

    @Column(name = "numero_apto")
    private String NumeroApto;

    @Column(name = "bloco_apto")
    private String BlocoApto;

    @Column(name = "data_cadastro")
    private LocalDate DataCadastro;

    @Column(name = "data_ultima_atualizacao")
    private LocalDate DataUltimaAtualizacao;

    @Column(name = "perfil_id")
    private Integer PerfilId;

    @Column(name = "condominio_id")
    private Integer CondominioId;
}