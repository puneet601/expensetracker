package com.project.ExpenseTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ExpenseTracker.entity.Role;

public interface RoleRepository extends JpaRepository<Role,Long>{

	Optional<Role> findByAuthority(String string);

}
