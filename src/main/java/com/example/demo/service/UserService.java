package com.example.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.model.entity.User;

@Service
public interface UserService {
	
	public UserDto getUserById(Integer userId); // 查詢單筆 User

	public void addUser(UserDto userDto); // 新增 User

	public void updateUser(Integer userId, UserDto userDto); // 修改 User

	public void deleteUser(Integer userId); // 刪除 User


}
