package com.example.demo04.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.demo04.dto.MemberDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomUser extends User{
	
	private MemberDTO member;

	public CustomUser(MemberDTO member) {
		super(member.getUserid(),
				member.getUserpw(),
				member.getAuthList().stream()
				.map(auth->new SimpleGrantedAuthority(auth.getAuth()))
				.collect(Collectors.toList()));
		this.member = member;
	}

}
