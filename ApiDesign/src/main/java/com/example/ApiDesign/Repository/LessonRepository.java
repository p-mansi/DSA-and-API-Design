package com.example.ApiDesign.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiDesign.Model.Course;
import com.example.ApiDesign.Model.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByCourse(Course course);

}
