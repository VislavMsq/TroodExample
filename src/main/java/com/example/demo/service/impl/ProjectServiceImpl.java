package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;
import com.example.demo.mapper.ProjectMapper;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectRepository.findAll().stream().map(ProjectMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<ProjectDto> getById(UUID id) {
        return projectRepository.findById(id).map(ProjectMapper::toDto);
    }

    @Override
    public ProjectDto create(ProjectDto dto) {
        Project entity = ProjectMapper.toEntity(dto);
        Project saved = projectRepository.save(entity);
        return ProjectMapper.toDto(saved);
    }

    @Override
    public Optional<ProjectDto> update(UUID id, ProjectDto dto) {
        return projectRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setDescription(dto.getDescription());
            return ProjectMapper.toDto(projectRepository.save(existing));
        });
    }

    @Override
    public void delete(UUID id) {
        projectRepository.deleteById(id);
    }
}
