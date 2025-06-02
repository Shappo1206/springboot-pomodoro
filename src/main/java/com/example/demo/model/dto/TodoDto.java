package com.example.demo.model.dto;

import java.time.LocalDateTime;

import lombok.Data;

// UserDto 對應於 User Entity
// 屬性名稱可以與所對應的 entity 不同
@Data
public class TodoDto {

		private Integer id; // 主鍵Id
		private Integer projectId; // 項目Id
		private String title; // Todo標題
		private String description; // Todo說明
		private boolean completed; // 完成度
		private int estimatedPomodoroCount;//番茄鐘數量預估
		private LocalDateTime createdTime ; //創建時間
}