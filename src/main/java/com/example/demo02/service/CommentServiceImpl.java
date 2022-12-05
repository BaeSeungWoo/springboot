package com.example.demo02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo02.dao.BoardMapper;
import com.example.demo02.dao.CommentMapper;
import com.example.demo02.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;
	
	@Override
	@Transactional
	public void insert(CommentDTO comment) {
		// 댓글 추가
		cmapper.insert(comment);
		// 댓글 개수 증가
		bmapper.updateReplyCnt(comment.getBnum(),1);
	}

	@Override
	public List<CommentDTO> getList(int bnum) {
		return cmapper.getList(bnum);
	}
		
	@Override
	@Transactional
	public void delete(int cnum) {
		CommentDTO comment = cmapper.findByNum(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
		cmapper.delete(cnum);
	}


	

}
