package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.dto.ProjectDto;

public interface ProjectService {

    List<ProjectDto> getAll();

    Optional<ProjectDto> getById(UUID id);

    ProjectDto create(ProjectDto project);

    Optional<ProjectDto> update(UUID id, ProjectDto project);

    void delete(UUID id);
}
