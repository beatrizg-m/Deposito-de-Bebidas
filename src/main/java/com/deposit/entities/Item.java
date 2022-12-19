package com.deposit.entities;

import java.math.BigDecimal;

public class Item {
    
    private int beverageId;
    private int units;
    private BigDecimal unitPrice;
    private BigDecimal amount;
    
    public Item(int beverageId, int units, BigDecimal unitPrice, BigDecimal amount) {
        this.beverageId = beverageId;
        this.units = units;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public int getbeverageId() {
        return beverageId;
    }

    public void setbeverageId(int beverageId) {
        this.beverageId = beverageId;
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
