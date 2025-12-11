package com.example.ApiDesign.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ApiDesign.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
