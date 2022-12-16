package com.deposit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deposit.entities.Bebida;

public interface DepositoRepository extends JpaRepository <Bebida, Integer> {

}
