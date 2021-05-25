package com.condomeasy.backend.dto;

import com.condomeasy.backend.model.Condominium;
import com.condomeasy.backend.model.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
    private Integer id;

    @NotEmpty(message = "Informe o nome do usuário.")
    private String name;

    @NotEmpty(message = "Informe o status do usuário.")
    private String status;

    @NotEmpty(message = "Informe o usuário.")
    private String username;

    @NotEmpty(message = "Informe o senha do usuário.")
    private String password;

    @NotEmpty(message = "Informe o sobrenome do usuário.")
    private String surname;

    @NotEmpty(message = "Informe o cpf do usuário.")
    private String cpf;

    @NotEmpty(message = "Informe o telefone do usuário")
    private String telephone;

    @NotEmpty(message = "Informe o email do usuário")
    private String email;

    @NotEmpty(message = "Informe o numero do apartemento do usuário")
    private String apartmentNumber;

    @NotEmpty(message = "Informe o bloco do usuário")
    private String apartmentBlock;

    private LocalDate registrationDate;

    private LocalDate lastUpdateDate;

    @NotNull(message = "Informe o perfil do usuário")
    private Profile profile;

    @NotNull(message = "Informe o condomínio do usuário")
    private Condominium condominium;
}
