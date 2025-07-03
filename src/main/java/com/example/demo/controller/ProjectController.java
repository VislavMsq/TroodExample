package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.doc.ProjectApi;
import com.example.demo.dto.ProjectDto;
import com.example.demo.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/projects")
public class ProjectController implements ProjectApi {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public List<ProjectDto> getAll() {
        return projectService.getAll();
    }

    @Override
    public ResponseEntity<ProjectDto> create(@Valid @RequestBody ProjectDto dto) {
        return ResponseEntity.ok(projectService.create(dto));
    }

    @Override
    public ResponseEntity<ProjectDto> update(@PathVariable String id, @Valid @RequestBody ProjectDto dto) {
        return projectService.update(UUID.fromString(id), dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable String id) {
        projectService.delete(UUID.fromString(id));
        return ResponseEntity.noContent().build();
    }
}
