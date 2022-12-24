package com.deposit.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order")
    private int id;

    @OneToMany(mappedBy = "order")
    @Column(name = "items")
    private ArrayList<Item> items;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "request_date")
    private Date requestDate;
    
    public Order(ArrayList<Item> items, BigDecimal amount, Date requestDate) {
        this.items = items;
        this.amount = amount;
        this.requestDate = requestDate;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getRequestDate() {
        return requestDate;
    }
 
}
