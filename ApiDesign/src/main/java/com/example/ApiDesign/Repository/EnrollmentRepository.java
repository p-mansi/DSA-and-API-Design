package com.example.ApiDesign.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiDesign.Model.Course;
import com.example.ApiDesign.Model.Enrollment;
import com.example.ApiDesign.Model.User;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {

    Optional<Enrollment> findByUserAndCourse(User user, Course course);

}
