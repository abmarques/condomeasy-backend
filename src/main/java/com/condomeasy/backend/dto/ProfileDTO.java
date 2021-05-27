package com.condomeasy.backend.dto;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

	private Integer id;
	@NotEmpty(message = "Informe o email do perfil.")
	private String name;
}
