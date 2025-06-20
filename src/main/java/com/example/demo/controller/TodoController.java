package com.example.demo.controller;

import com.example.demo.model.dto.AddTodoRequestDto;
import com.example.demo.model.dto.AddTodoResponseDto;
import com.example.demo.model.dto.TodoDto;
import com.example.demo.repository.TodoRepository;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.TodoService;

import jakarta.validation.Valid;
import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:5173"} , allowCredentials = "true")//跨域請求，每個controller都要加
@RestController
@RequestMapping("/rest/todo")
public class TodoController {

    private final UserRegisterRequestController userRegisterRequestController;

    @Autowired
    private TodoService todoService;
    
    @Autowired
    public TodoRepository todoRepository;

    TodoController(UserRegisterRequestController userRegisterRequestController) {
        this.userRegisterRequestController = userRegisterRequestController;
    }

    // ✅ 查詢全部 Todo
 // ✅ 測試用：查詢全部 Todo (含 debug log)
    @GetMapping("")
    public ResponseEntity<ApiResponse<List<TodoDto>>> getAllTodos() {
        try {
            // 先打個 log 讓你看 service 有沒有被呼叫
            //System.out.println("✅ Controller 被呼叫：getAllTodos()");

            List<TodoDto> todos = todoService.findAllTodos();

            // 印出目前撈出來的筆數
            //System.out.println("✅ 取得筆數：" + todos.size());
            for (TodoDto todo : todos) {
                //System.out.println("✔ TodoId: " + todo.getTodoId() + " | Title: " + todo.getTitle());
            }

            return ResponseEntity.ok(ApiResponse.success("查詢成功", todos));
        } catch (Exception e) {
            e.printStackTrace(); // 印出完整錯誤方便 debug
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "查詢失敗: " + e.getMessage()));
        }
    }

    // ✅ 查詢單筆 Todo
    @GetMapping("/find/{todoId}")
    public ResponseEntity<ApiResponse<TodoDto>> getTodoById(@PathVariable Integer todoId) {
        try {
            TodoDto todo = todoService.getTodoById(todoId);
            return ResponseEntity.ok(ApiResponse.success("查詢成功", todo));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.error(404, "找不到資料: " + e.getMessage()));
        }
    }

    // ✅ 新增 Todo
    @PostMapping("")
    public ResponseEntity<ApiResponse<AddTodoResponseDto>> createTodo(@RequestBody AddTodoRequestDto request) {
    	System.out.println("有進入POST");
    	try {
            AddTodoResponseDto response = todoService.addTodo(request);
            return ResponseEntity.ok(ApiResponse.success("新增成功", response));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "新增失敗: " + e.getMessage()));
        }
    }

    // ✅ 更新 Todo
    @PutMapping("/put/{todoId}")
    public ResponseEntity<ApiResponse<String>> updateTodo(@PathVariable Integer todoId, @RequestBody AddTodoRequestDto request) {
        try {
            todoService.updateTodo(todoId, request);
            return ResponseEntity.ok(ApiResponse.success("更新成功", null));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "更新失敗: " + e.getMessage()));
        }
    }

    // ✅ 刪除 Todo
    @DeleteMapping("/rm/{todoId}")
    public ResponseEntity<ApiResponse<String>> deleteTodo(@PathVariable Integer todoId) {
        try {
            todoService.deleteTodo(todoId);
            return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.error(500, "刪除失敗: " + e.getMessage()));
        }
    }
}
