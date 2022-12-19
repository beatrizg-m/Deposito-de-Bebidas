package com.deposit.entities;

import java.math.BigInteger;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "beverages")
public class Beverage {
     

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @Column(name = "alcoholic")
    private Boolean alcoholic;

    @Column(name = "alcoholic_strength")
    private int alcoholicStrength;

    @Column(name = "price")
    private BigInteger price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "volume_ml")
    private int volumeMl;
   
    @JsonCreator
    public Beverage(
        @JsonProperty("name") String name,
        @JsonProperty("alcoholic") Boolean alcoholic,
        @JsonProperty("alcoholicStrength") int alcoholicStrength,
        @JsonProperty("price") BigInteger price,
        @JsonProperty("stock") int stock,
        @JsonProperty("volumeMl") int volumeMl
    ) {
        this.name = name;
        this.alcoholic = alcoholic;
        this.alcoholicStrength = alcoholicStrength;
        this.price = price;
        this.stock = stock;
        this.volumeMl = volumeMl;
    }

    public Beverage(){}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getAlcoholic() {
        return alcoholic;
    }

    public int getAlcoholicStrength() {
        return alcoholicStrength;
    }

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public void setId(int id) {
    }

    public Beverage delete(int id) {
        return null;
    }
    
}
