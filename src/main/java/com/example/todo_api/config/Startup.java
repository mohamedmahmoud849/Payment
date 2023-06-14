package com.example.todo_api.config;

import com.example.todo_api.model.CreditCard;
import com.example.todo_api.model.Person;
import com.example.todo_api.repository.CardPaymentRepo;
import com.example.todo_api.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {

    @Autowired
    CardPaymentRepo cardPaymentRepo;

    @Autowired
    PersonRepo personRepo;
    @Override
    public void run(String... args) throws Exception {

       /* personRepo.save(Person.builder()
                .name("mohamed")
                .username("moh")
                .password("123")
                .build());

        personRepo.save(Person.builder()
                .name("ahmed")
                .username("hamada")
                .password("123")
                .build());

        personRepo.save(Person.builder()
                .name("abdo")
                .username("bido")
                .password("123")
                .build());

        cardPaymentRepo.save(new CreditCard("1234567890123456", 1000, Person.builder()
                .name("mohamed")
                .username("moh")
                .password("123")
                .build()));

        cardPaymentRepo.save(new CreditCard("2345678901234567", 500, Person.builder()
                .name("ahmed")
                .username("hamada")
                .password("123")
                .build()));
        cardPaymentRepo.save(new CreditCard("3456789012345678", 1500, Person.builder()
                .name("abdo")
                .username("bido")
                .password("123")
                .build()));*/

    }
}
