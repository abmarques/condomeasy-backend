package com.condomeasy.backend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	
    private Integer id;

    @NotNull(message = "Informe o nome do usuário")
    private String name;

    @NotNull(message = "Informe o status do usuário")
    private String status;

    @NotNull(message = "Informe o usuário")
    private String user;

    @NotNull(message = "Informe o senha do usuário")
    private String password;

    @NotNull(message = "Informe o sobrenome do usuário")
    private String surname;

    @NotNull(message = "Informe o cpf do usuário")
    private String cpf;

    @NotNull(message = "Informe o telefone do usuário")
    private String telephone;

    @NotNull(message = "Informe o email do usuário")
    private String email;

    @NotNull(message = "Informe o numero do apartemento do usuário")
    private String apartmentNumber;

    @NotNull(message = "Informe o bloco do usuário")
    private String apartmentBlock;

    @Column(name = "data_cadastro")
    private LocalDate registrationDate;

    @Column(name = "data_ultima_atualizacao")
    private LocalDate lastUpdateDate;

    @NotNull(message = "Informe o perfil do usuário")
    private Integer profileId;

    @NotNull(message = "Informe o condomínio do usuário")
    private Integer condominiumId;
}
