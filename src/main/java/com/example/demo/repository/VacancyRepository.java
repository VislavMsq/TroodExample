package com.example.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Vacancy;

public interface VacancyRepository extends JpaRepository<Vacancy, UUID> {

    List<Vacancy> findByProjectId(UUID projectId);
}
