package com.example.ApiDesign.Service;

import org.springframework.stereotype.Service;

import com.example.ApiDesign.Model.Course;
import com.example.ApiDesign.Model.Enrollment;
import com.example.ApiDesign.Model.User;
import com.example.ApiDesign.Repository.CourseRepository;
import com.example.ApiDesign.Repository.EnrollmentRepository;
import com.example.ApiDesign.Repository.UserRepository;

@Service
public class EnrollemntService {

    private final EnrollmentRepository enrollmentRepo;
    private final UserRepository userRepo;
    private final CourseRepository courseRepo;

    public EnrollemntService(EnrollmentRepository enrollmentRepo, UserRepository userRepo,
            CourseRepository courseRepo) {
        this.enrollmentRepo = enrollmentRepo;
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
    }

    public String enroll(Long userId, Long courseId) {

        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Course course = courseRepo.findById(courseId).orElseThrow(() -> new RuntimeException("Course not found"));

        if (enrollmentRepo.findByUserAndCourse(user, course).isPresent()) {
            return "User is already enrolled in this course";
        }

        Enrollment enrollment = new Enrollment(null, user, course);
        enrollmentRepo.save(enrollment);

        return "Enrollment Successfull";
    }
}
