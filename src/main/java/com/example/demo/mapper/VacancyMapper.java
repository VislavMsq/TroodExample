package com.example.demo.mapper;

import com.example.demo.dto.VacancyDto;
import com.example.demo.entity.Project;
import com.example.demo.entity.Vacancy;

public class VacancyMapper {

    public static VacancyDto toDto(Vacancy v) {
        VacancyDto dto = new VacancyDto();
        dto.setId(v.getId());
        dto.setTitle(v.getTitle());
        dto.setDescription(v.getDescription());
        dto.setProjectId(v.getProject() != null ? v.getProject().getId() : null);
        return dto;
    }

    public static Vacancy toEntity(VacancyDto dto) {
        Vacancy v = new Vacancy();
        v.setId(dto.getId());
        v.setTitle(dto.getTitle());
        v.setDescription(dto.getDescription());
        if (dto.getProjectId() != null) {
            Project p = new Project();
            p.setId(dto.getProjectId());
            v.setProject(p);
        }
        return v;
    }
}
