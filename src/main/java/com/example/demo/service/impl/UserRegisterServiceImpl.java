package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserRegisterService;
import com.example.demo.service.UserService;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(String username, String password, String email) {
		// 先寫一個最簡單的版本來測試
		System.out.println("收到註冊請求：");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Email: " + email);
		
		// 暫時先不實際存入資料庫，先讓 API 能回應
		// TODO: 之後加上真正的註冊邏輯
	}
	
	@Override
	public void emailConfirmOK(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean ifUserExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}
}