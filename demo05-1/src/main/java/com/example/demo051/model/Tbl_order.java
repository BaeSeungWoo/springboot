package com.example.demo051.model;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Tbl_order {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderid;
	private String note;
	private String ordername;
	private int price;
	
	@JoinColumn(name = "user_id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Tbl_user tbl_user;

}
