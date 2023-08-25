package com.project.ExpenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ExpenseTracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
