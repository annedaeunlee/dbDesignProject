package com.example.project.repositories;

import com.example.project.models.Course;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository
        extends CrudRepository<Course, Integer> {
}
