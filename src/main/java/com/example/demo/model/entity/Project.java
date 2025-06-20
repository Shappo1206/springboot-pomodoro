package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "project")
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Integer projectId;
    
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "completed", nullable = false)
    private Boolean completed = false;
    
//    // 一對多關聯：一個專案可以有多個任務
//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Todo> todos = new ArrayList<>();
	
}
