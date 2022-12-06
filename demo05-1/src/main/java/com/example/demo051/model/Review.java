package com.example.demo051.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_review") // 테이블 이름 재 설정
public class Review {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int rate;
	private String comment;
	private Date ratingDate;
	
	@JoinColumn(name="hotel_id") // Hotel 에 대한 왜래 키 설정
	@ManyToOne // 다 대 일
	private Hotel hotel;
	
}
