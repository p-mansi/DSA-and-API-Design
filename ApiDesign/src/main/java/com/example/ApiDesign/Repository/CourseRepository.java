package com.example.ApiDesign.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiDesign.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long courseId);
}
