package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddTodoRequestDto {
    private Integer userId;
    private String title;
    private String description;
	private Boolean completed; 
    private int estimatePomodoroCount;
}