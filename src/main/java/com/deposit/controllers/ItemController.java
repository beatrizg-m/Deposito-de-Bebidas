package com.deposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deposit.entities.Beverage;
import com.deposit.entities.Item;
import com.deposit.entities.ItemRequestBody;
import com.deposit.repositories.BeverageRepository;
import com.deposit.repositories.ItemRepository;


@RestController
public class ItemController {
    
    @Autowired
    private ItemRepository repository;

    @Autowired
    private BeverageRepository beverageRepository;
    
    @PostMapping(value = "/item")
    ResponseEntity<Object> addsItem(@RequestBody ItemRequestBody requestBodyItem){
        Beverage beverage = beverageRepository.findById(requestBodyItem.getBeverageId()).orElseThrow();
        Item items = new Item(requestBodyItem.getUnits(), beverage);
        repository.save(items);
        return ResponseEntity.status(HttpStatus.CREATED).body(items);
    }

}
