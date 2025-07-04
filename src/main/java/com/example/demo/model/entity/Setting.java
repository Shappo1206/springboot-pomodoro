package com.example.demo.model.entity;

import java.time.LocalDateTime;

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
@Table(name = "settings") // 可選:可以手動建立資料表名
public class Setting {
	
	
	@Id
	@Column(name = "user_id", nullable = false) // 資料表 user 中預設的欄位名稱
	private Integer userId; // 使用者 ID
	
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
