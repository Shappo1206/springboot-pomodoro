package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.TimerSession;

@Repository
//在 TimerSession Repository 中加入統計方法
public interface TimerSessionRepository extends JpaRepository<TimerSession, Integer>{
 // 統計特定待辦事項已完成的番茄鐘數量
 Integer countCompletedPomodorosByTodoId(Integer todoId);
 
 // 統計特定待辦事項正在進行的番茄鐘數量
 Integer countRunningPomodorosByTodoId(Integer todoId);
 
 // 統計特定待辦事項的總工作時間
 Integer sumActualDurationByTodoId(Integer todoId);
}