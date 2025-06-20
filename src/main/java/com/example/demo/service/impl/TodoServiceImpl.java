package com.example.demo.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.AddTodoRequestDto;
import com.example.demo.model.dto.AddTodoResponseDto;
import com.example.demo.model.dto.TodoDto;
import com.example.demo.model.entity.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<TodoDto> findAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        System.out.println("資料庫回傳幾筆：" + todos.size());

        List<TodoDto> todoDtos = todos.stream()
                .map(entity -> new TodoDto(
                        entity.getTodoId(),
                        
                        entity.getTitle(),
                        entity.getDescription(),
                        entity.isCompleted(),
                        entity.getEstimatePomodoroCount(),
                        entity.getCreatedTime()
                ))
                .collect(Collectors.toList());

        return todoDtos;
    }

    // 查詢單筆 Todo
    @Override
    public TodoDto getTodoById(Integer todoId) {
        Optional<Todo> todoOpt = todoRepository.findById(todoId);
        if (todoOpt.isPresent()) {
            Todo entity = todoOpt.get();
            return new TodoDto(
                    entity.getTodoId(),
                    entity.getTitle(),
                    entity.getDescription(),
                    entity.isCompleted(),
                    entity.getEstimatePomodoroCount(),
                    entity.getCreatedTime());
        } else {
            return null; // 你也可以改成丟出自訂 exception
        }
    }

 // 新增 Todo
    @Override
    public AddTodoResponseDto addTodo(AddTodoRequestDto requestDto) {
        Todo entity = new Todo();
        entity.setUserId(requestDto.getUserId());
        entity.setTitle(requestDto.getTitle());
        entity.setDescription(requestDto.getDescription());
        entity.setCompleted(false);  // 新增時預設尚未完成
        entity.setEstimatePomodoroCount(requestDto.getEstimatePomodoroCount());
        entity.setCreatedTime(LocalDateTime.now());

        // 儲存到資料庫
        Todo saved = todoRepository.save(entity);

        // 包裝回傳結果 (補齊完整欄位)
        AddTodoResponseDto response = new AddTodoResponseDto();
        response.setTodoId(saved.getTodoId());
        response.setTitle(saved.getTitle());
        response.setDescription(saved.getDescription());
        response.setCompleted(saved.isCompleted());
        response.setEstimatePomodoroCount(saved.getEstimatePomodoroCount());
        response.setMessage("新增成功！");

        return response;
    }

 // 更新 Todo
    @Override
    public void updateTodo(Integer todoId, AddTodoRequestDto requestDto) {
        Optional<Todo> todoOpt = todoRepository.findById(todoId);
        if (todoOpt.isPresent()) {
            Todo entity = todoOpt.get();
            entity.setTitle(requestDto.getTitle());
            entity.setDescription(requestDto.getDescription());
            entity.setCompleted(requestDto.getCompleted());
            entity.setEstimatePomodoroCount(requestDto.getEstimatePomodoroCount());
            todoRepository.save(entity);
        }
    }


    // 刪除 Todo
    @Override
    public void deleteTodo(Integer todoId) {
    	if (!todoRepository.existsById(todoId)) {
            throw new EntityNotFoundException("找不到 todoId: " + todoId);
        }
        todoRepository.deleteById(todoId);
    }


}
