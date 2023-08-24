package com.project.ExpenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ExpenseTracker.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
