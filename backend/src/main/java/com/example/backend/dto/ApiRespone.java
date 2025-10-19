package com.example.backend.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class ApiRespone<T> {
    private boolean success;
    private T data;
    private String message;

    public ApiRespone(boolean success, T data, String msg){
        this.success = success;
        this.data = data;
        this.message = msg;
    }

}
