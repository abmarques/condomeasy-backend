package com.condomeasy.backend.dto.user;

import com.condomeasy.backend.dto.ProfileDTO;
import com.condomeasy.backend.dto.base.BaseDTO;
import com.condomeasy.backend.model.Profile;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseDTO {
	
    private String name;

    private String status;

    private String username;

    @JsonIgnore
    private String password;

    private String surname;

    private String cpf;

    private String telephone;

    private String email;

    private String apartmentNumber;

    private String apartmentBlock;

    private LocalDateTime registrationDate;

    private LocalDateTime lastUpdateDate;

    private LocalDateTime lastLoginDate;

    @JsonIgnore
    private String ProfileName;

    private Integer profileId;

    private Integer condominiumId;

}
