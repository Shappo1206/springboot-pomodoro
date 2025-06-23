package com.example.demo.model.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Integer todoId;

    @Column(name = "user_id", nullable = true)
    private Integer userId;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "completed", nullable = false)
    private boolean completed;
    
    @Column(name = "completed_pomodoros", nullable = false)
    private Integer completedPomodoroCount = 0;

    @Column(name = "estimate_pomodoro", nullable = false)
    private Integer estimatePomodoroCount;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdTime;
    
// // 多對一關聯：多個任務屬於一個專案
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
//    private Project project;
}
