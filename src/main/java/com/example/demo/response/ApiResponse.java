package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 統一回應格式：
 * status  → 狀態碼（例如：200, 400, 500）
 * message → 說明訊息（例如：查詢成功、異常錯誤）
 * payload → 回傳資料（可以為 null）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private int status;      
    private String message;  
    private T payload;       

    // ✅ 成功回傳（帶 payload）
    public static <T> ApiResponse<T> success(String message, T payload) {
        return new ApiResponse<>(200, message, payload);
    }

    // ✅ 成功回傳（不帶 payload）
    public static ApiResponse<Void> success(String message) {
        return new ApiResponse<>(200, message, null);
    }

    // ✅ 失敗回傳
    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }
}
