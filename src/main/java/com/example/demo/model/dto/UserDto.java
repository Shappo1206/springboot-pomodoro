package com.example.demo.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

// UserDto 對應於 User Entity
// 屬性名稱可以與所對應的 entity 不同
@Data
public class UserDto {

		private Integer userId; // 主鍵Id
		private String username; // 
		private String email; //
		private boolean active;//
		private String role; // 權限
		private LocalDateTime createdAt ; //創建時間
}