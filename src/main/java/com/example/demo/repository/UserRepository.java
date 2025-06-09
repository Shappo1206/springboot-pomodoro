package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

/* 我要的功能：新增一個User（save）
 * UserRepository.save(User)
 * UserRepository.findByUsername/findByEmail * 
 */

// Spring JPA
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
	public boolean findByEmail(String Email);
	
	// JPA 自動生成以下方法，所以這裡不用實作

    /* 新增方法
    // 保存單個 User
    User save(User entity);

    // 批量保存多個 User
    List<User> saveAll(Iterable<User> entities);
    */

    /* 查詢方法
    // 根據 ID 查詢（ID 類型是 Integer）
    Optional<User> findById(Integer id);

    // 檢查指定 ID 的 User 是否存在
    boolean existsById(Integer id);

    // 查詢所有 User
    List<User> findAll();

    // 排序查詢所有 User
    List<User> findAll(Sort sort);

    // 分頁查詢所有 User
    Page<User> findAll(Pageable pageable);

    // 根據多個 ID 查詢
    List<User> findAllById(Iterable<Integer> ids);

    // 統計 User 總數
    long count();
    */

    /* 刪除方法
    // 根據 ID 刪除
    void deleteById(Integer id);

    // 刪除指定的 User 實體
    void delete(User entity);

    // 批量刪除
    void deleteAll(Iterable<? extends User> entities);

    // 刪除所有 User（危險操作！）
    void deleteAll();

    // 根據多個 ID 批量刪除
    void deleteAllById(Iterable<? extends Integer> ids);
    */
}
