package com.example.ApiDesign.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ApiDesign.DTO.LessonResponse;
import com.example.ApiDesign.Model.*;
import com.example.ApiDesign.Repository.*;

@Service
public class LessonAccessService {

    private final UserRepository userRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollmentRepo;
    private final LessonRepository lessonRepo;

    public LessonAccessService(
            UserRepository userRepo,
            CourseRepository courseRepo,
            EnrollmentRepository enrollmentRepo,
            LessonRepository lessonRepo) {

        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
        this.enrollmentRepo = enrollmentRepo;
        this.lessonRepo = lessonRepo;
    }

    public List<LessonResponse> getLessons(Long userId, Long courseId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));

        // Check if user is enrolled in the course
        if (enrollmentRepo.findByUserAndCourse(user, course).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "User is not enrolled in this course");
        }

        // Fetch lessons
        List<Lesson> lessons = lessonRepo.findByCourse(course);

        return lessons.stream()
                .map(l -> new LessonResponse(l.getId(), l.getName()))
                .collect(Collectors.toList());
    }
}
