package com.condomeasy.backend.dto;

import javax.validation.constraints.NotEmpty;

import com.condomeasy.backend.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO extends BaseDTO {

	@NotEmpty(message = "Informe o nome do perfil.")
	private String name;
}
