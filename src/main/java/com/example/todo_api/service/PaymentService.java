package com.example.todo_api.service;


import com.example.todo_api.Response.Error.CardNotFound;
import com.example.todo_api.Response.Error.InsufficientBalance;
import com.example.todo_api.Response.Success.PaymentSucceeded;
import com.example.todo_api.model.CreditCard;
import com.example.todo_api.model.RequestData;
import com.example.todo_api.repository.CardPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentService
{
    @Autowired
    CardPaymentRepo cardPaymentRepo ;
    @PostMapping("/pay")
    public @ResponseBody ResponseEntity<Object> create(
            @RequestBody RequestData request) {

        // Retrieve the updated credit card information
        CreditCard creditCard = cardPaymentRepo.getCardInformation(request.getCardNumber());

        if(creditCard == null)
        {
            return ResponseEntity.of(java.util.Optional.of(new CardNotFound()));
        }

        // Card information exists in the database
        int currentBalance = creditCard.getBalance();
        if (currentBalance < request.getAmountToBePaid())
        {
            // Insufficient balance
            return ResponseEntity.of(java.util.Optional.of(new InsufficientBalance()));
        }
        int newBalance = currentBalance - request.getAmountToBePaid();

        cardPaymentRepo.modifyCardBalance(request.getCardNumber(), newBalance);
        return ResponseEntity.of(java.util.Optional.of(new PaymentSucceeded()));


    }

}
