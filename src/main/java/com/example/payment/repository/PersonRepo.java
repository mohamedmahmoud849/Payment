package com.example.payment.repository;

import com.example.payment.model.ServiceConsumer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepo extends JpaRepository<ServiceConsumer,Long> {

    Optional<ServiceConsumer> findByUsername(String username);
}
