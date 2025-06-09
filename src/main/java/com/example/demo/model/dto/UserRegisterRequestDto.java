package com.example.demo.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDto {
	//註冊資料
	
	/*private Integer userId; 使用者註冊時根本不該自己提供 userId。
→ 這是資料庫自動生成的，不能暴露在 DTO 裡。*/
	@NotBlank
	private String username; // 使用者姓名
	
	@Email
	@NotBlank
	private String email; //信箱
	
	@Size(min=8)
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$", 
    message = "密碼需包含大小寫英文字母與數字")
	private String password;

}