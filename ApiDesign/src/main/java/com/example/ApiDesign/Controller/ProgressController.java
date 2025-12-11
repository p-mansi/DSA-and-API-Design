package com.example.ApiDesign.Controller;

import com.example.ApiDesign.DTO.ProgressResponse;
import com.example.ApiDesign.Service.ProgressService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping("/{userId}/courses/{courseId}/progress")
    public ProgressResponse getProgress(
            @PathVariable Long userId,
            @PathVariable Long courseId) {

        return progressService.getProgress(userId, courseId);
    }
}
