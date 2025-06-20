package com.example.demo.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// UserDto 對應於 User Entity
// 屬性名稱可以與所對應的 entity 不同
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
	//private Integer userId; // Id
	private Integer todoId; // Id
	private String title; 
	private String description; 
	private Boolean completed; 
	private int estimatePomodoroCount;
	private LocalDateTime createdTime ;	
}