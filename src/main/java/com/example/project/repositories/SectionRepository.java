package com.example.project.repositories;

import com.example.project.models.Section;

import org.springframework.data.repository.CrudRepository;

public interface SectionRepository
    extends CrudRepository<Section, Integer> {
}
