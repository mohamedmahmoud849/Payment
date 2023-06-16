package com.example.payment.Response.Success;

import com.example.payment.Response.JsonMessageResponse;

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
