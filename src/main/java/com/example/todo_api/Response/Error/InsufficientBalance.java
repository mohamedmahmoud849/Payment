package com.example.todo_api.Response.Error;


import com.example.todo_api.Response.JsonMessageResponse;

public class InsufficientBalance extends JsonMessageResponse {
    public InsufficientBalance(String m)
    {
        super(m);
    }
    public InsufficientBalance()
    {
        message = "Insufficient Balance, cannot proceed with payment process";
    }
}
