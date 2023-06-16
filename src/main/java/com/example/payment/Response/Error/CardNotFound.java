package com.example.payment.Response.Error;


import com.example.payment.Response.JsonMessageResponse;

public class CardNotFound extends JsonMessageResponse {
    public CardNotFound(String m)
    {
        super(m);
    }
    public CardNotFound()
    {
        message = "Card not found, cannot proceed with payment process";
    }
}
