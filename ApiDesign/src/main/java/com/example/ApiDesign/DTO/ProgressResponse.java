package com.example.ApiDesign.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProgressResponse {
    private int totalLessons;
    private int completedLessons;
    private String progress;
}
