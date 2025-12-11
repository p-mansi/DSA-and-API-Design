package com.example.ApiDesign.Service;

import org.springframework.stereotype.Service;

import com.example.ApiDesign.Model.*;
import com.example.ApiDesign.Repository.*;

@Service
public class RatingService {

    private final RatingRepository ratingRepo;
    private final UserRepository userRepo;
    private final CourseRepository courseRepo;
    private final EnrollmentRepository enrollmentRepo;

    public RatingService(
            RatingRepository ratingRepo,
            UserRepository userRepo,
            CourseRepository courseRepo,
            EnrollmentRepository enrollmentRepo) {
        this.ratingRepo = ratingRepo;
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
        this.enrollmentRepo = enrollmentRepo;
    }

    public String addRating(Long userId, Long courseId, int ratingValue) {

        if (ratingValue < 1 || ratingValue > 5) {
            return "Rating must be between 1 and 5";
        }

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // Check enrollment
        if (enrollmentRepo.findByUserAndCourse(user, course).isEmpty()) {
            return "User is not enrolled in this course";
        }

        // Check if rating exists (1 rating per user)
        if (ratingRepo.findByUserAndCourse(user, course).isPresent()) {
            return "User has already rated this course";
        }

        Rating rating = new Rating(null, ratingValue, user, course);
        ratingRepo.save(rating);

        return "Rating submitted successfully";
    }

    public double getCourseRating(Long courseId) {

        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        var ratings = ratingRepo.findByCourse(course);

        if (ratings.isEmpty()) {
            return 0;
        }

        double sum = ratings.stream().mapToInt(Rating::getRating).sum();
        return sum / ratings.size();
    }
}
