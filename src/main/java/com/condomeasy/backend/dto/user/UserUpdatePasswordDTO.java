package com.condomeasy.backend.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdatePasswordDTO {

    @NotEmpty(message = "Informe o senha do usuário.")
    @Length(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
        private String oldPassword;

    @NotEmpty(message = "Informe o senha do usuário.")
    @Length(min = 8, message = "A senha deve conter no mínimo 8 caracteres.")
    private String newPassword;

}
