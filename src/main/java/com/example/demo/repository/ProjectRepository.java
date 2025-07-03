package com.example.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
