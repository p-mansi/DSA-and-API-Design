package com.example.ApiDesign.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiDesign.Model.Lesson;
import com.example.ApiDesign.Model.LessonComplete;
import com.example.ApiDesign.Model.User;

public interface LessonCompleteRepository extends JpaRepository<LessonComplete, Long> {

    Optional<LessonComplete> findByUserAndLesson(User user, Lesson lesson);

}
