package com.example.demo.service.impl;

import java.time.LocalDateTime;

import com.example.demo.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserRegisterService;
import com.example.demo.service.UserService;
import com.example.demo.util.HashUtil;
/* 1.接收前端傳來的資料
 * 2.進行各種驗證（格式、長度、帳號是否已存在等）
 * 3.密碼加密處理
 * 4.將資料儲存到資料庫
 * 5.回傳適當的回應給前端
 */
@Service
public class UserRegisterServiceImpl implements UserRegisterService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(String username, String password, String email) throws Exception{
		/* 先寫一個最簡單的版本來測試
		System.out.println("收到註冊請求：");
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Email: " + email);
		暫時先不實際存入資料庫，先讓 API 能回應
		TODO: 之後加上真正的註冊邏輯
		*/
		
		// 3.1 & 3.2 的驗證邏輯（你已經完成）
		
        // 3.3 密碼加密處理
		//步驟一｜先做一個鹽巴
		//步驟二｜再加上鹽巴
		String salt = HashUtil.generateSalt();
		String passwordHash = HashUtil.hashPassword(password, salt);
		
		//3.4把註冊資料放進DB
		//3.4-1 建立User實體
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setSalt(salt);
		user.setPasswordHash(passwordHash);
		
		//3.4-2 設定使用者的預設值
        user.setActive(true);
        user.setRole("使用者");
        user.setCreatedAt(LocalDateTime.now());
        
        //3.4-3 將資料儲存到資料庫
        userRepository.save(user);
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