package com.deposit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deposit.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    
}
