package com.example.ApiDesign.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.ApiDesign.DTO.LessonResponse;
import com.example.ApiDesign.Service.LessonAccessService;

@RestController
@RequestMapping("/courses")
public class LessonAccessController {

    private final LessonAccessService lessonAccessService;

    public LessonAccessController(LessonAccessService lessonAccessService) {
        this.lessonAccessService = lessonAccessService;
    }

    // GET: /courses/{courseId}/lessons?userId=1
    @GetMapping("/{courseId}/lessons")
    public List<LessonResponse> getLessons(
            @PathVariable Long courseId,
            @RequestParam Long userId) {

        return lessonAccessService.getLessons(userId, courseId);
    }
}
