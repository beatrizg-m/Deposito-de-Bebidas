package com.deposit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deposit.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
    
}
