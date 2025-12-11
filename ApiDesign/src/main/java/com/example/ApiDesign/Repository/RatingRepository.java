package com.example.ApiDesign.Repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ApiDesign.Model.*;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    Optional<Rating> findByUserAndCourse(User user, Course course);

    List<Rating> findByCourse(Course course);
}
