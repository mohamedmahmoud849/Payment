package com.example.todo_api.Response;

import lombok.Data;

@Data
public abstract class JsonMessageResponse 
{
    protected String message;
    public JsonMessageResponse(String m)
    {
        message = m;
    }
    public JsonMessageResponse(){}
}
