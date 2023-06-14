package com.example.todo_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RequestData {
    private String cardNumber;
    private int amountToBePaid;
}
