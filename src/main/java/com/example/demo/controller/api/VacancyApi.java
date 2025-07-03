package com.example.demo.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Vacancy;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Вакансии", description = "Управление вакансиями")
public interface VacancyApi {

    @Operation(
            summary = "Получить вакансии проекта",
            description = "Возвращает список вакансий для указанного проекта",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Список вакансий",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vacancy.class))
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Проект не найден",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @GetMapping("/projects/{projectId}/vacancies")
    List<Vacancy> getByProject(@Parameter(description = "ID проекта") @PathVariable String projectId);

    @Operation(
            summary = "Добавить вакансию к проекту",
            description = "Добавляет новую вакансию к проекту",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Вакансия успешно добавлена",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vacancy.class))
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Проект не найден",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Ошибка валидации",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @PostMapping("/projects/{projectId}/vacancies")
    ResponseEntity<Vacancy> create(
            @Parameter(description = "ID проекта") @PathVariable String projectId,
            @Valid @RequestBody Vacancy vacancy);

    @Operation(
            summary = "Обновить вакансию",
            description = "Обновляет вакансию по ID",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Вакансия успешно обновлена",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = Vacancy.class))
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Вакансия не найдена",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @PutMapping("/vacancies/{id}")
    ResponseEntity<Vacancy> update(
            @Parameter(description = "ID вакансии") @PathVariable String id,
            @Valid @RequestBody Vacancy vacancy);

    @Operation(
            summary = "Удалить вакансию",
            description = "Удаляет вакансию по ID",
            responses = {
                @ApiResponse(
                        responseCode = "204",
                        description = "Вакансия успешно удалена"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Вакансия не найдена",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @DeleteMapping("/vacancies/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "ID вакансии") @PathVariable String id);
}
