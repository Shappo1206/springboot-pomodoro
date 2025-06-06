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

	/*Service 實作 addUser(UserDto userDto)
	 * 1｜驗證 DTO 資料是否符合規範（例如：email 格式、密碼長度）
	 * 2｜使用 userDto.getPassword() 取得密碼欄位
	 * 3｜產生 salt，並加密密碼（Hash.getSalt() + Hash.getHash()）
	 * 4｜建立 User Entity（注意這是資料庫用的，不同於 DTO）
	 * 5｜把 DTO 中的欄位與處理過的密碼值一併塞進 User Entity
	 * 6｜呼叫 userRepository.save(user) 儲存到資料庫*/
	
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
