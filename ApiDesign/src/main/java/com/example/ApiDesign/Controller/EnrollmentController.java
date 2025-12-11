package com.example.ApiDesign.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ApiDesign.Service.EnrollemntService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/courses")
public class EnrollmentController {

    private final EnrollemntService enrollemntService;

    public EnrollmentController(EnrollemntService enrollemntService) {
        this.enrollemntService = enrollemntService;
    }

    @PostMapping("/{courseId}/enroll")
    public String postMethodName(@PathVariable Long courseId, @RequestParam Long userId) {

        return enrollemntService.enroll(userId, courseId);
    }

}
