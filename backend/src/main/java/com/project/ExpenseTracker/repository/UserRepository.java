package com.project.ExpenseTracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.ExpenseTracker.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	User findUserByEmail(String username);

	@Query(nativeQuery = true, value="SELECT * FROM USER WHERE email = ?1 AND password = ?2")
	Optional<User> findByEmailAndPassword(String email, String password);

	Optional<User> findByEmail(String username);

}
