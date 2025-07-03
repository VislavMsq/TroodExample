package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.doc.VacancyApi;
import com.example.demo.dto.VacancyDto;
import com.example.demo.service.VacancyService;

import jakarta.validation.Valid;

@RestController
public class VacancyController implements VacancyApi {

    private final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @Override
    public List<VacancyDto> getByProject(@PathVariable String projectId) {
        return vacancyService.getByProjectId(UUID.fromString(projectId));
    }

    @Override
    public ResponseEntity<VacancyDto> create(@PathVariable String projectId, @Valid @RequestBody VacancyDto dto) {
        return vacancyService.create(UUID.fromString(projectId), dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<VacancyDto> update(@PathVariable String id, @Valid @RequestBody VacancyDto dto) {
        return vacancyService.update(UUID.fromString(id), dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable String id) {
        vacancyService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
