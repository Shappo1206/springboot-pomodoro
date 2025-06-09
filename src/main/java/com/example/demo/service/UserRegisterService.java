package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service

public interface UserRegisterService {
	
	// 新增 User
    void addUser(String username, String password, String email) throws Exception;		
	// email 驗證成功
	void emailConfirmOK(String username);
	
	//1.檢查這個帳號或 email 有沒有註冊過
	boolean ifUserExist(String email);	
	//2.密碼加密
	//已經寫了HashUtil
	
	//3.寫進資料庫（轉成 User Entity 存進 UserRepository）

	//4.寄 Email 驗證信（進階）
	
}
