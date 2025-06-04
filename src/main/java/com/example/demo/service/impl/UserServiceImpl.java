package com.example.demo.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// 查詢單筆 User
	@Override
	public UserDto getUserById(Integer userId) {
		return userRepository.findById(userId)
			.map(user -> modelMapper.map(user, UserDto.class))
			.orElse(null); // 或者丟個例外，依你高貴的邏輯
	}

	// 新增 User
	@Override
	public void addUser(UserDto userDto) {
		
	}

	// 修改 User
	@Override
	public void updateUser(Integer userId, UserDto userDto) {
		
	}

	// 刪除 User
	@Override
	public void deleteUser(Integer userId) {
		
	}

}
