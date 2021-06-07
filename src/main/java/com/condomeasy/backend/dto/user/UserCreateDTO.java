package com.condomeasy.backend.dto.user;

import com.condomeasy.backend.dto.base.DefaultDTO;
import com.condomeasy.backend.validator.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDTO extends DefaultDTO {

    @NotEmpty(message = "Informe o nome do usuário.")
    private String name;

    @NotEmpty(message = "Informe o status do usuário.")
    private String status;

    @UsernameValidator
    @ExistsUsernameValidator
    @NotEmpty(message = "Informe o usuário.")
    @Length(min = 1, max = 20, message = "O usuário deve conter entre 1 a 20 caracteres.")
    private String username;

    @NotEmpty(message = "Informe o senha do usuário.")
    @Length(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
    private String password;

    @NotEmpty(message = "Informe o sobrenome do usuário.")
    private String surname;

    @CPFValidator
    @ExistsCPFValidator
    @NotEmpty(message = "Informe o cpf do usuário.")
    private String cpf;

    @NotEmpty(message = "Informe o telefone do usuário")
    private String telephone;

    @EmailValidator
    @ExistsEmailValidator
    @NotEmpty(message = "Informe o email do usuário")
    private String email;

    @NotEmpty(message = "Informe o numero do apartemento do usuário")
    private String apartmentNumber;

    @NotEmpty(message = "Informe o bloco do usuário")
    private String apartmentBlock;

    @NotNull(message = "Informe o perfil do usuário")
    private Integer profileId;

    @NotNull(message = "Informe o condomínio do usuário")
    private Integer condominiumId;

    private LocalDateTime registrationDate;

}
