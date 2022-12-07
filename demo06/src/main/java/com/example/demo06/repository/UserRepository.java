package com.example.demo06.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo06.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    // query method :	
	// findBy는 기본적으로 select 속성을 가짐. 뒤의 이름은 조건절을 명시하며 객체의 속성이름이 적혀야 함.
	User findByUsername(String username);
}
