package com.deposit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.deposit.entities.Beverage;
import com.deposit.repositories.BeverageRepository;

@RestController
public class BeverageController {
  
    @Autowired
    private BeverageRepository repository;

    @PostMapping (value = "/beverages")
    public ResponseEntity<Beverage> registerBeverage(@RequestBody Beverage beverage){
        Beverage result = repository.save(beverage);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/beverages/{id}")
    public ResponseEntity<?> searchBeverage(@PathVariable(value = "id") int id){
        Object result = repository.findById(id);
        if (repository.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("unregistered Beverage");
    }

    
    @GetMapping(value = "/beverages")
    public ResponseEntity<Page<Beverage>> allBeverages(
        @RequestParam(required = false, defaultValue = "0") int page_number,
        @RequestParam(required = false, defaultValue = "5") int page_size,
        @RequestParam(required = false) String sort,
        @RequestParam(required = false) Boolean alcoholic
      ){
        Pageable pageable;
        
        if (sort != null) {
          Sort sortConfig;
          if(sort.substring(0, 1).equals("-")){
            sortConfig = Sort.by(Sort.Direction.DESC, sort.substring(1));
          } else {
            sortConfig = Sort.by(Sort.Direction.ASC, sort);
          }
          pageable = PageRequest.of(page_number - 1, page_size, sortConfig);
        } else {
        pageable = PageRequest.of(page_number - 1, page_size);
      }
      Page<Beverage> result;

      if (alcoholic != null) {
        result = repository.findByAlcoholic(alcoholic, pageable);
      } else {
        result = repository.findAll(pageable);
      }

      return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PutMapping(value = "/beverages/{id}")
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

    @DeleteMapping(value = "/beverages/{id}")
    ResponseEntity<String> deleteBeverage(@PathVariable("id") int id) {
      if(repository.existsById(id)) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("id deleted");
      }

      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("unregistered id");
    }

    
}
