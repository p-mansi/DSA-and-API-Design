package com.example.ApiDesign.Service;

import org.springframework.stereotype.Service;

import com.example.ApiDesign.Model.Course;
import com.example.ApiDesign.Model.Lesson;
import com.example.ApiDesign.Model.LessonComplete;
import com.example.ApiDesign.Model.User;
import com.example.ApiDesign.Repository.EnrollmentRepository;
import com.example.ApiDesign.Repository.LessonCompleteRepository;
import com.example.ApiDesign.Repository.LessonRepository;
import com.example.ApiDesign.Repository.UserRepository;

@Service
public class LessonCompleteService {

    private final LessonCompleteRepository lessonCompleteRepo;
    private final EnrollmentRepository enrollmentRepo;
    private final LessonRepository lessonRepo;
    private final UserRepository userRepo;

    public LessonCompleteService(
            LessonCompleteRepository lessionCompleteRepository,
            EnrollmentRepository enrollmentRepository,
            LessonRepository lessonRepository,
            UserRepository userRepository) {
        this.enrollmentRepo = enrollmentRepository;
        this.lessonRepo = lessonRepository;
        this.lessonCompleteRepo = lessionCompleteRepository;
        this.userRepo = userRepository;
    }

    public String completeLesson(Long userId, Long courseId, Long lessonId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Lesson lesson = lessonRepo.findById(lessonId).orElseThrow(() -> new RuntimeException("Lesson Not Found"));

        if (!lesson.getCourse().getId().equals(courseId)) {
            return "Lesson does not belong to this course";
        }

        Course course = lesson.getCourse();
        if (enrollmentRepo.findByUserAndCourse(user, course).isEmpty()) {
            return "User is not enrolled in this course";
        }

        if (lessonCompleteRepo.findByUserAndLesson(user, lesson).isPresent()) {
            return "Lesson already completed";
        }

        LessonComplete lessonComplete = new LessonComplete(null, user, lesson);
        lessonCompleteRepo.save(lessonComplete);

        return "Lesson completion progress recorded";
    }
}
