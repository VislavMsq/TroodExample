package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.VacancyDto;
import com.example.demo.entity.Vacancy;
import com.example.demo.mapper.VacancyMapper;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.VacancyRepository;
import com.example.demo.service.VacancyService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<VacancyDto> getByProjectId(UUID projectId) {
        return vacancyRepository.findByProjectId(projectId).stream().map(VacancyMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<VacancyDto> getById(UUID id) {
        return vacancyRepository.findById(id).map(VacancyMapper::toDto);
    }

    public Optional<VacancyDto> create(UUID projectId, VacancyDto dto) {
        return projectRepository.findById(projectId).map(project -> {
            Vacancy vacancy = VacancyMapper.toEntity(dto);
            vacancy.setId(null);               // <— сбрасываем, чтобы Hibernate сделал INSERT
            vacancy.setProject(project);
            Vacancy saved = vacancyRepository.save(vacancy);
            return VacancyMapper.toDto(saved);
        });
    }

    @Override
    public Optional<VacancyDto> update(UUID id, VacancyDto dto) {
        return vacancyRepository.findById(id).map(existing -> {
            existing.setTitle(dto.getTitle());
            existing.setDescription(dto.getDescription());
            Vacancy saved = vacancyRepository.save(existing);
            return VacancyMapper.toDto(saved);
        });
    }

    @Override
    public void delete(UUID id) {
        vacancyRepository.deleteById(id);
    }
}
