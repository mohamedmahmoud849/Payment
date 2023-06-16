package com.example.payment.controller;


import com.example.payment.Response.Error.CardNotFound;
import com.example.payment.Response.Error.InsufficientBalance;
import com.example.payment.Response.Success.PaymentSucceeded;
import com.example.payment.model.CreditCard;
import com.example.payment.model.RequestData;
import com.example.payment.repository.CardPaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment/pay")
public class PaymentController
{
    @Autowired
    CardPaymentRepo cardPaymentRepo ;
    @PostMapping("/check")
    public ResponseEntity<Object> checkCreditCard(@RequestBody RequestData request) {
        // Retrieve the updated credit card information
        CreditCard creditCard = cardPaymentRepo.getCardInformation(request.getCardNumber());
        if(creditCard == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CardNotFound());
        }
        // Card information exists in the database
        int currentBalance = creditCard.getBalance();
        if (currentBalance < request.getAmountToBePaid())
        {
            // Insufficient balance
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new InsufficientBalance());
        }
        return ResponseEntity.status(HttpStatus.OK).body(new PaymentSucceeded("There's Enough Balance"));
    }

    @PostMapping("/consume")
    public ResponseEntity<Object> payWithCreditCard(@RequestBody RequestData request) {

        // Retrieve the updated credit card information
        CreditCard creditCard = cardPaymentRepo.getCardInformation(request.getCardNumber());

        if(creditCard == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new CardNotFound());
        }

        // Card information exists in the database
        int currentBalance = creditCard.getBalance();
        if (currentBalance < request.getAmountToBePaid())
        {
            // Insufficient balance
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new InsufficientBalance());
        }
        int newBalance = currentBalance - request.getAmountToBePaid();

        cardPaymentRepo.modifyCardBalance(request.getCardNumber(), newBalance);
        return ResponseEntity.status(HttpStatus.OK).body(new PaymentSucceeded());
    }

}
