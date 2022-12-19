package com.deposit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deposit.entities.Beverage;

public interface BeverageRepository extends JpaRepository <Beverage, Integer> {

}
