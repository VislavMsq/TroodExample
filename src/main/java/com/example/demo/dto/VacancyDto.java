package com.example.demo.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO вакансии")
public class VacancyDto {

    @Schema(description = "ID вакансии")
    private UUID id;
    @Schema(description = "Название вакансии")
    private String title;
    @Schema(description = "Описание вакансии")
    private String description;
    @Schema(description = "ID проекта")
    private UUID projectId;
}
