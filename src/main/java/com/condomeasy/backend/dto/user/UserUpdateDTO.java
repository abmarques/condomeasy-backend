package com.condomeasy.backend.dto.user;

import com.condomeasy.backend.dto.base.BaseDTO;
import com.condomeasy.backend.validator.annotation.EmailValidator;
import com.condomeasy.backend.validator.annotation.UsernameValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDTO extends BaseDTO {

    @NotEmpty(message = "Informe o nome do usuário.")
    private String name;

    @NotEmpty(message = "Informe o status do usuário.")
    private String status;

    @UsernameValidator
    @NotEmpty(message = "Informe o usuário.")
    private String username;

    @NotEmpty(message = "Informe o sobrenome do usuário.")
    private String surname;

    @NotEmpty(message = "Informe o telefone do usuário")
    private String telephone;

    @EmailValidator
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

    private LocalDateTime lastUpdateDate;
}
