package com.deposit.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.deposit.entities.Beverage;

public interface BeverageRepository extends JpaRepository <Beverage, Integer> {

    List<Beverage> findAll();
    Page<Beverage> findByAlcoholic(Boolean bool, Pageable pageable);
    // Page<User> page = findAllByProgramId(Integer programId, Pageable pageable);

}
