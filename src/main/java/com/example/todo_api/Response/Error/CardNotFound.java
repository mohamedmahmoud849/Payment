package com.example.todo_api.Response.Error;


import com.example.todo_api.Response.JsonMessageResponse;

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
