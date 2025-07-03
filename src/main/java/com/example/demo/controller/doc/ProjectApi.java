package com.example.demo.controller.doc;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.ProjectDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "Проекты", description = "Управление проектами")
public interface ProjectApi {

    @Operation(
            summary = "Получить все проекты",
            description = "Возвращает список всех проектов",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Список проектов",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))
                )
            }
    )
    @GetMapping("/projects")
    List<ProjectDto> getAll();

    @Operation(
            summary = "Создать проект",
            description = "Создаёт новый проект",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Проект успешно создан",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))
                ),
                @ApiResponse(
                        responseCode = "400",
                        description = "Ошибка валидации",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @PostMapping("/projects")
    ResponseEntity<ProjectDto> create(@Valid @RequestBody ProjectDto project);

    @Operation(
            summary = "Обновить проект",
            description = "Обновляет существующий проект по ID",
            responses = {
                @ApiResponse(
                        responseCode = "200",
                        description = "Проект успешно обновлён",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = ProjectDto.class))
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Проект не найден",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @PutMapping("/projects/{id}")
    ResponseEntity<ProjectDto> update(
            @Parameter(description = "ID проекта") @PathVariable UUID id,
            @Valid @RequestBody ProjectDto project);

    @Operation(
            summary = "Удалить проект",
            description = "Удаляет проект по ID",
            responses = {
                @ApiResponse(
                        responseCode = "204",
                        description = "Проект успешно удалён"
                ),
                @ApiResponse(
                        responseCode = "404",
                        description = "Проект не найден",
                        content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
                )
            }
    )
    @DeleteMapping("/projects/{id}")
    ResponseEntity<Void> delete(@Parameter(description = "ID проекта") @PathVariable String id);
}
