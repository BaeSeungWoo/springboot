package com.example.demo051.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tbl_user {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;
	private String address;
	private String nickname;
	private String username;
	
	@OneToMany(mappedBy = "tbl_user")
	private List<Tbl_order> tbl_order;

}
