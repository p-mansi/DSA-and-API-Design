package com.example.ApiDesign.Controller;

import com.example.ApiDesign.Service.RatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    // POST /courses/{courseId}/rating?userId=1&value=5
    @PostMapping("/{courseId}/rating")
    public String rateCourse(
            @PathVariable Long courseId,
            @RequestParam Long userId,
            @RequestParam int value) {

        return ratingService.addRating(userId, courseId, value);
    }

    // GET /courses/{courseId}/rating
    @GetMapping("/{courseId}/rating")
    public String getRating(@PathVariable Long courseId) {

        double avg = ratingService.getCourseRating(courseId);
        return "Average rating: " + avg;
    }
}
