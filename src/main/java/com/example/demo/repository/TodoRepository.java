package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.dto.TodoDto;
import com.example.demo.model.entity.Todo;

//Spring JPA
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
//JPA自動生成以下方法，所以這裡不用寫方法
	
/*新增方法
// 保存單個 Todo
Todo save(Todo entity);

// 批量保存多個 Todo
List<Todo> saveAll(Iterable<Todo> entities);
*/
	
/*查詢方法
// 根據 ID 查詢（ID 類型是 Integer）
Optional<Todo> findById(Integer id);

// 檢查指定 ID 的 Todo 是否存在
boolean existsById(Integer id);

// 查詢所有 Todo
List<Todo> findAll();

// 排序查詢所有 Todo
List<Todo> findAll(Sort sort);

// 分頁查詢所有 Todo
Page<Todo> findAll(Pageable pageable);

// 根據多個 ID 查詢
List<Todo> findAllById(Iterable<Integer> ids);

// 統計 Todo 總數
long count();
*/
	
/*
// 根據 ID 刪除
void deleteById(Integer id);

// 刪除指定的 Todo 實體
void delete(Todo entity);

// 批量刪除
void deleteAll(Iterable<? extends Todo> entities);

// 刪除所有 Todo（危險操作！）
void deleteAll();

// 根據多個 ID 批量刪除
void deleteAllById(Iterable<? extends Integer> ids);
*/
}
