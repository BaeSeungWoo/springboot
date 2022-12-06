package com.example.demo04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo04.dto.BoardDTO;
import com.example.demo04.service.BoardService;

@RequestMapping("/board/*")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService bservice;
		
	@GetMapping("insert")
	@PreAuthorize("isAuthenticated()")
	public void insert() {
	}
	
	@PostMapping("insert")
	public String insert(BoardDTO board){
		bservice.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("list")
	public String list(Model model){
		model.addAttribute("boards", bservice.list());
		return "board/list";
	}
	
	@GetMapping("view/{num}")
	public String view(@PathVariable int num, Model model) {
		model.addAttribute("view",bservice.findByNum(num));
		return "board/view";
	}

}
