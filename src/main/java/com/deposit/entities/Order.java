package com.deposit.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;


public class Order {
    
    private ArrayList<Item> items;
    private BigDecimal amount;
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
