package com.example.demo02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo02.dto.BoardDTO;

@Mapper
public interface BoardMapper {
	
	@Insert("insert into board(title, writer, content) values(#{title},#{writer},#{content})")
	public void insert(BoardDTO board);
	
	// @Select("select * from board")
	public List<BoardDTO> list();
	
	@Select("select * from board where num = #{num}")
	public BoardDTO findByNum(int num);
	
	
	public int getCount();
	
	@Delete("delete from board where num = #{num}")
	public void delete(int num);
	
	@Update("update board set title = #{title}, content = #{content}, regdate = now() where num = #{num}")
	public void update(BoardDTO board);
	
	@Update("update board set replycnt = replycnt+#{amount} where num = #{bnum}")
	public void updateReplyCnt(@Param("bnum")int bnum, @Param("amount")int amount);

}
