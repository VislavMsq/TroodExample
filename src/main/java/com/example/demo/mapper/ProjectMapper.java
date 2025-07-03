package com.example.demo.mapper;

import com.example.demo.dto.ProjectDto;
import com.example.demo.entity.Project;

public class ProjectMapper {

    public static ProjectDto toDto(Project p) {
        ProjectDto dto = new ProjectDto();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setDescription(p.getDescription());
        return dto;
    }

    public static Project toEntity(ProjectDto dto) {
        Project p = new Project();
        p.setId(dto.getId());
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        return p;
    }
}
