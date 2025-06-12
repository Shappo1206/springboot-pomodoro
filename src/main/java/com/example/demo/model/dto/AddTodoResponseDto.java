package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddTodoResponseDto {
    private Integer todoId;
    private Integer projectId;
    private String title;
    private String description;
    private Boolean completed;
    private int estimatePomodoroCount;

    // 新增這個欄位
    private String message;
}
