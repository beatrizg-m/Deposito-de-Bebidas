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

import com.deposit.entities.Bebida;
import com.deposit.repositories.DepositoRepository;

@RestController
public class DepositoController {
    
    @Autowired
    private DepositoRepository deposito;


    @PostMapping (value = "/bebidas")
    public ResponseEntity<Bebida> inserirBebida(@RequestBody Bebida bebida){
        Bebida result = deposito.save(bebida);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/bebidas/{id}")
    public ResponseEntity<?> buscarBebida(@PathVariable(value = "id") int id){
        Object result = deposito.findById(id);
        if (deposito.existsById(id)) {
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bebida nao cadastrada");
    }

    @PutMapping(value = "/bebidas/{id}")
    ResponseEntity<?> updateBebida(@RequestBody Bebida newBebida, @PathVariable int id) {
      if (!deposito.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bebida nao cadastrada.");
      }
      Bebida bebida = deposito.findById(id).orElseThrow();
      bebida.setEstoque(newBebida.getEstoque());
      bebida.setPreco(newBebida.getPreco());
      deposito.save(bebida);

      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping(value = "bebidas/{id}")
    ResponseEntity<String> deleteBebida(@PathVariable("id") int id) {
      if(deposito.existsById(id)) {
        deposito.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("id deletado");
      }

      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("id nao existente");
    }
}
