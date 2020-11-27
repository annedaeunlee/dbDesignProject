package com.example.project.repositories;

import com.example.project.models.Student;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository
    extends CrudRepository<Student, Integer> {
}
