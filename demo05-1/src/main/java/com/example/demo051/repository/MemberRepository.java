package com.example.demo051.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo051.model.JpaMember;

public interface MemberRepository extends JpaRepository<JpaMember, Long>{

}
