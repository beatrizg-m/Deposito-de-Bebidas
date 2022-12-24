package com.deposit.entities;

import java.math.BigInteger;


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
    private Integer units;

    @Column(name = "unitPrice")
    private BigInteger unitPrice;

    @Column(name = "amount")
    private BigInteger amount;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Item(){}
    
    public Item(Integer units, Beverage beverage) {
        this.units = units;  
        this.beverage = beverage;
        this.unitPrice = this.beverage.getPrice();
        this.amount = this.unitPrice.multiply(BigInteger.valueOf(this.units));
        
    }

    public int getId(){
        return id;
    }

    public Beverage getbeverage() {
        return beverage;
    }


    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public BigInteger getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigInteger unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    

    
}
