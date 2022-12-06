package com.example.demo04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo04.dto.BoardDTO;
import com.example.demo04.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper bmapper;

	public void insert(BoardDTO board) {
		bmapper.insert(board);
	}

	public List<BoardDTO> list(){
		return bmapper.list();
	}

	public BoardDTO findByNum(int num) {
		return bmapper.findByNum(num);
	}

	public void update(BoardDTO board) {
		
	}

	public void delete(int num) {
		
	}

	public int getCount() {
		return 0;
	}

}
