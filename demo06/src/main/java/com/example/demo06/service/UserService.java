package com.example.demo06.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo06.model.User;
import com.example.demo06.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public void save(User user) {
		// 비밀번호 암호화
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		
		// 권한 설정
		user.setRole("ROLE_USER");
		
		// 회원가입
		userRepository.save(user);			
	}

}
