package com.example.ApiDesign.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // generate getters and setters
@Entity // Marks as JPA table
@NoArgsConstructor // automatically generates a constructor with no parameters.
@AllArgsConstructor // automatically generates a constructor with all fields as parameters.
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
