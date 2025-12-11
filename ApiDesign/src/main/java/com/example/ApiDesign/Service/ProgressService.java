package com.example.ApiDesign.Service;

import com.example.ApiDesign.DTO.ProgressResponse;
import com.example.ApiDesign.Model.*;
import com.example.ApiDesign.Repository.*;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

        private final LessonRepository lessonRepo;
        private final LessonCompleteRepository completionRepo;
        private final EnrollmentRepository enrollmentRepo;
        private final UserRepository userRepo;
        private final CourseRepository courseRepo;

        public ProgressService(LessonRepository lessonRepo,
                        LessonCompleteRepository completionRepo,
                        EnrollmentRepository enrollmentRepo,
                        UserRepository userRepo,
                        CourseRepository courseRepo) {
                this.lessonRepo = lessonRepo;
                this.completionRepo = completionRepo;
                this.enrollmentRepo = enrollmentRepo;
                this.userRepo = userRepo;
                this.courseRepo = courseRepo;
        }

        public ProgressResponse getProgress(Long userId, Long courseId) {

                User user = userRepo.findById(userId)
                                .orElseThrow(() -> new RuntimeException("User not found"));

                Course course = courseRepo.findById(courseId)
                                .orElseThrow(() -> new RuntimeException("Course not found"));

                // Enrolled check
                if (enrollmentRepo.findByUserAndCourse(user, course).isEmpty()) {
                        throw new RuntimeException("User is not enrolled in this course");
                }

                // Total lessons
                int totalLessons = lessonRepo.findByCourse(course).size();

                // Completed lessons
                int completedLessons = (int) completionRepo.findAll().stream()
                                .filter(c -> c.getUser().equals(user) &&
                                                c.getLesson().getCourse().equals(course))
                                .count();

                // Calculate percentage
                double percentage = (totalLessons == 0)
                                ? 0
                                : (completedLessons * 100.0) / totalLessons;

                return new ProgressResponse(totalLessons, completedLessons, percentage + "%");
        }
}
