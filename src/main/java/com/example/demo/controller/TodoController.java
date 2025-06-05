package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.TodoDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.TodoService;
import com.example.demo.service.impl.TodoServiceImpl;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
/**
請求方法 URL 路徑              功能說明      請求參數                                   回應
--------------------------------------------------------------------------------------------------------------------
GET    /rest/todo            取得所有 Todo 列表 無                                       成功時返回所有 Todo 的列表 payload 及成功訊息。
GET    /rest/todo/{todoId}   取得指定 Todo 資料 todoId (路徑參數，待辦 ID)                成功時返回指定 Todo 資料及 payload 成功訊息。
POST   /rest/todo            新增 Todo       請求體包含 todoDto                         成功時返回成功訊息，並包含 payload。
PUT    /rest/todo/{todoId}   更新指定 Todo 資料 todoId (路徑參數，待辦 ID)，請求體包含 todoDto 成功時返回成功訊息，並包含 payload。
DELETE /rest/todo/{todoId}   刪除指定 Todo    todoId (路徑參數，待辦 ID)                  成功時返回成功訊息，不包含 payload。
*/

@CrossOrigin(origins = "http://localhost:5173")
@RestController //這個東西會自動幫你把方法回傳的物件變成 JSON 格式。
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/api/todos")
	public ResponseEntity<ApiResponse<List<TodoDto>>> getAllTodos() {
		try {
			List<TodoDto> todos = todoService.findAllTodos();
			return ResponseEntity.ok(ApiResponse.success("登入成功", todos));
	    } catch (Exception e) {
	        return ResponseEntity
	                .status(HttpStatus.UNAUTHORIZED)
	                .body(ApiResponse.error(401, "登入失敗: " + e.getMessage()));
	    }
	}

}
