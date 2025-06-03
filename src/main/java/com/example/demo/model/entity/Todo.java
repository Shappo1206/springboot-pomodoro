package com.example.demo.model.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // 實體類與資料表對應(會自動建立資料表)
@Table(name = "todos") // 可選:可以手動建立資料表名
public class Todo {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成 id
		@Column(name = "id")
		private Integer id; // 主鍵 ID
		
		@Column(name = "project_id", nullable = false)
		private Integer projectId;
		
		@Column(name = "title", nullable = false, length = 50)
		private String title;
		
		@Column(name = "description", length = 255)
		private String description;
		
		@Column(name = "completed", nullable = false)
		private boolean completed;
		
		@Column(name = "estimate_pomodoro", nullable = false)
		private int estimatePomodoroCount;
		
		@CreationTimestamp
		@Column(name = "created_at", nullable = false, updatable = false)
		private LocalDateTime createdTime ;

}
