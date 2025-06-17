package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.TodoDto;
import com.example.demo.model.dto.UserRegisterRequestDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.UserRegisterService;
import com.example.demo.service.UserService;

import jakarta.validation.Valid;

/**
請求方法 URL 路徑                功能說明         請求參數                                回應
----------------------------------------------------------------------------------------------------------
POST   /rest/register            註冊帳號         請求體包含 RegisterRequestDto           成功時返回成功訊息，並包含 payload。
GET    /rest/register/checkEmail 檢查 Email 重複  查詢參數 email                          回傳 email 是否已被註冊。
POST   /rest/register/sendMail   寄出驗證信       email                                   成功時回傳「驗證信已寄出」訊息。
GET    /rest/register/verify     驗證信點擊連結   查詢參數 token                           回傳驗證結果。
*/

@Validated
@RestController
public class UserRegisterRequestController {
	
	@Autowired
	private UserRegisterService userRegisterService;
	
	//避免從前端接收任何垃圾輸入：空密碼、爛 email、emoji
	//	@PostMapping("/api/auth/register")
	//	public ResponseEntity<?> register(@RequestBody @Valid RegisterRequestDto request){
	//		
	//		return;
	//	}
	
	@PostMapping("/user/register")
	public ApiResponse<Void> addUser(@RequestBody @Valid UserRegisterRequestDto request) {
		/*方法內部邏輯流程：
		 * 接收並驗證前端傳來的註冊資料
		 * 呼叫 Service 層進行註冊處理
		 * 根據處理結果返回適當的回應*/
		try {
			userRegisterService.addUser(request.getUsername(), request.getPassword(), request.getEmail());
	        return ApiResponse.success("註冊成功", null);
	    } catch (Exception e) {
	        return ApiResponse.error(400, "註冊失敗：" + e.getMessage());
	    }
		
	}
	
	
}
