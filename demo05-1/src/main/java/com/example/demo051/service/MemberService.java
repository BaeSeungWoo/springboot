package com.example.demo051.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo051.model.JpaMember;
import com.example.demo051.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	// 추가
	public void save(JpaMember member) {
		memberRepository.save(member);
	}
	
	// 전체보기
	public List<JpaMember> list(){
		return memberRepository.findAll();
	}
	
	// 상세보기 select * from jpa_member where id = 3
	public JpaMember detail(Long id) {
		return memberRepository.findById(id).get();
	}
	
	// 삭제
	public void delete(Long id) {
		memberRepository.deleteById(id);
	}
	
	// 수정(더티체크 : 변경 감지)
	@Transactional
	public void update(JpaMember member) {
	  	JpaMember m = memberRepository.findById(member.getId()).get();
	  	m.setAddr(member.getAddr());
	  	m.setEmail(member.getEmail());
	  	m.setMemo(member.getMemo());
	  	m.setName(member.getName());
	  	m.setPassword(member.getPassword());
	}

}










