package com.example.demo06.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo06.model.Board;
import com.example.demo06.model.User;
import com.example.demo06.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Transactional(readOnly = true) // 성능적 측면을 위해 flush를 자동으로 호출하지 못하게 함.
// flush가 필요한 메서드에만 transactional 어노테이션을 붙여 flush 호출.
// 일반적으로 컨트롤러에서 db를 변경할 권한을 주진 않음. 기본적으로 select 기능만 부여시킴.
@Service
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	
	// 추가
	// String 형태가 아닌, user. 즉 객체 형태로 받아야 함. 이것이 객체 지향적 설계를 의미함.
	@Transactional
	public void save(Board board, User user) {
		board.setUser(user);
		boardRepository.save(board);
	}
	
	// 전체 보기(페이징 x)
	public List<Board> findAll(){
		return boardRepository.findAll();
	}
	
	// 전체 보기(페이징 o)
	public Page<Board> findAll(Pageable pageable){
		return boardRepository.findAll(pageable);
	}
	
	// 개수
	public Long count() {
		return boardRepository.count();
	}
	
	// 상세 보기
	@Transactional
	public Board view(Long num) {
		Board board = boardRepository.findById(num).get();
		board.setHitcount(board.getHitcount()+1);
		return board;
	}
	

}
