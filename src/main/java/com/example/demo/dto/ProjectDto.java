package com.example.demo.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO проекта")
public class ProjectDto {

    @Schema(description = "ID проекта")
    private UUID id;
    @Schema(description = "Название проекта")
    private String name;
    @Schema(description = "Описание проекта")
    private String description;
}
