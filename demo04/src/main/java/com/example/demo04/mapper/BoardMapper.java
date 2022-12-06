package com.example.demo04.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo04.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	
	public void insert(BoardDTO board);
	public List<BoardDTO> list();
	public BoardDTO findByNum(int num);

}
