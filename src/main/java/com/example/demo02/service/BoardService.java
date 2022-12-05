package com.example.demo02.service;

import java.util.List;



import com.example.demo02.dto.BoardDTO;


public interface BoardService {
	
	public void insert(BoardDTO board);
	
	public List<BoardDTO> list();
	
	public BoardDTO findByNum(int num);
	
	public void update(BoardDTO board);
	
	public void delete(int num);
	
	public int getCount();

}
