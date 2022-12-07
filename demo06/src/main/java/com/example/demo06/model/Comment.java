package com.example.demo06.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name = "tbl_comment6")
public class Comment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cnum;
	private String userid;
	private String content;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date regdate;
	
	@ManyToOne
	@JoinColumn(name = "bnum")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

}
