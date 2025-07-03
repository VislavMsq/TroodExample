package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dto.VacancyDto;

public interface VacancyService {

    List<VacancyDto> getByProjectId(UUID projectId);

    Optional<VacancyDto> getById(UUID id);

    Optional<VacancyDto> create(UUID projectId, VacancyDto vacancy);

    Optional<VacancyDto> update(UUID id, VacancyDto vacancy);

    void delete(UUID id);
}
