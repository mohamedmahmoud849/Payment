package com.example.payment.Response.Error;


import com.example.payment.Response.JsonMessageResponse;

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
