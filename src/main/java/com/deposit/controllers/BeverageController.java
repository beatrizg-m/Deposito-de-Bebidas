package com.deposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deposit.entities.Beverage;
import com.deposit.repositories.BeverageRepository;

@RestController
public class BeverageController {
    
    @Autowired
    private BeverageRepository repository;


    @PostMapping (value = "/beverage")
    public ResponseEntity<Beverage> registerBeverage(@RequestBody Beverage Beverage){
        Beverage result = repository.save(Beverage);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/beverage/{id}")
    public ResponseEntity<?> searchBeverage(@PathVariable(value = "id") int id){
        Object result = repository.findById(id);
        if (repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unregistered Beverage");
    }

    @PutMapping(value = "/beverage/{id}")
    ResponseEntity<?> updateBeverage(@RequestBody Beverage newBeverage, @PathVariable int id) {
      if (!repository.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("unregistered Beverage.");
      }
      Beverage Beverage = repository.findById(id).orElseThrow();
      Beverage.setStock(newBeverage.getStock());
      Beverage.setPrice(newBeverage.getPrice());
      repository.save(Beverage);

      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping(value = "/beverage/{id}")
    ResponseEntity<String> deleteBeverage(@PathVariable("id") int id) {
      if(repository.existsById(id)) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("id deleted");
      }

      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("unregistered id");
    }
}
