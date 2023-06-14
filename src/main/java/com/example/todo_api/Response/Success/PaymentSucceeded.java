package com.example.todo_api.Response.Success;

import com.example.todo_api.Response.JsonMessageResponse;

public class PaymentSucceeded extends JsonMessageResponse
{
    public PaymentSucceeded(String m)
    {
        super(m);
    }
    public PaymentSucceeded()
    {
        message = "Transaction Succeeded";
    }
}
