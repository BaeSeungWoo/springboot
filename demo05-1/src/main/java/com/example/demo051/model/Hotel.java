package com.example.demo051.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Hotel {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Enumerated(EnumType.STRING) // enum 형을 사용하기 위함.
	private Grade grade;
	@Embedded // address 형들을 모두 포함시킴.
	private Address address;
	
	@OneToMany(mappedBy = "hotel") // 일 대 다
	private List<Review> reviews;
	

}
