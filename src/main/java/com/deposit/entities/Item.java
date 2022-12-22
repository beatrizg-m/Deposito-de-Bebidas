package com.deposit.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "items")
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "beverage_id", nullable = false)
    private Beverage beverage;

    @Column(name = "units")
    private int units;

    @Column(name = "unitPrice")
    private BigDecimal unitPrice;

    @Column(name = "amount")
    private BigDecimal amount;
    
    public Item(int id, int units, BigDecimal unitPrice, BigDecimal amount) {
        this.id = id;
        this.units = units;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public int getId(){
        return id;
    }

    public Beverage getbeverage() {
        return beverage;
    }


    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    

    
}
