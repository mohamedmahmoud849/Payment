package com.example.todo_api.repository;


import com.example.todo_api.model.CreditCard;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CardPaymentRepo extends JpaRepository<CreditCard,String> {


    @Query(value = "SELECT card_number, balance FROM credit_card WHERE card_number=:card_number", nativeQuery = true)
    CreditCard getCardInformation(@Param("card_number")String card_number) ;

    @Query(value = "UPDATE credit_card SET balance=:newBalance WHERE card_number=:card_number", nativeQuery = true)
    @Transactional
    @Modifying
    public void modifyCardBalance(@Param("card_number") String cardNumber,@Param("newBalance") int newBalance);


}
