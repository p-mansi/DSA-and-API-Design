package com.example.ApiDesign.Controller;

import org.springframework.web.bind.annotation.*;

import com.example.ApiDesign.Service.LessonCompleteService;

@RestController
@RequestMapping("/courses")
public class LessonController {

    private final LessonCompleteService lessonService;

    public LessonController(LessonCompleteService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping("/{courseId}/lessons/{lessonId}/complete")
    public String completeLesson(
            @PathVariable Long courseId,
            @PathVariable Long lessonId,
            @RequestParam Long userId) {

        return lessonService.completeLesson(userId, courseId, lessonId);
    }
}
