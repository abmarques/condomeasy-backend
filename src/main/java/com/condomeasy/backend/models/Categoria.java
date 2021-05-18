package com.condomeasy.backend.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
@Table(name = "tb_categoria")
public class Categoria extends BaseModel {
}