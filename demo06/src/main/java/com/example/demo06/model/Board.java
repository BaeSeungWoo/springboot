package com.example.demo06.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name = "tbl_board6")
public class Board {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long num;
	private String title;
	// private String writer;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date regdate;
	private int hitcount;
	private int replycnt;
	
	@OneToMany(mappedBy = "board")
	private List<Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@PrePersist
	public void prePersist() {
		this.hitcount = this.hitcount == 0 ? 0 : this.hitcount;
		this.replycnt = this.replycnt == 0 ? 0 : this.replycnt;
	}

}
