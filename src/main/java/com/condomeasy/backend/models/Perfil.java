package com.condomeasy.backend.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "tb_perfil")
public class Perfil extends BaseModel {
}