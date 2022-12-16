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
@Table(name = "bebidasDeposito")
public class Bebida {
     

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @Column(name = "alcoolica")
    private Boolean alcoolica;

    @Column(name = "teorAlcoolico")
    private int teorAlcoolico;

    @Column(name = "preco")
    private BigInteger preco;

    @Column(name = "estoque")
    private int estoque;

    @Column(name = "volumeMl")
    private int volumeMl;
   
    @JsonCreator
    public Bebida(
        @JsonProperty("nome") String nome,
        @JsonProperty("alcoolica") Boolean alcoolica,
        @JsonProperty("teorAlcoolico") int teorAlcoolico,
        @JsonProperty("preco") BigInteger preco,
        @JsonProperty("estoque") int estoque,
        @JsonProperty("volumeMl") int volumeMl
    ) {
        this.nome = nome;
        this.alcoolica = alcoolica;
        this.teorAlcoolico = teorAlcoolico;
        this.preco = preco;
        this.estoque = estoque;
        this.volumeMl = volumeMl;
    }

    public Bebida(){}

    public int getId() {
        return id;
    }

    public String getNomeBebida() {
        return nome;
    }

    public Boolean getAlcoolica() {
        return alcoolica;
    }

    public int getTeorAcoolico() {
        return teorAlcoolico;
    }

    public BigInteger getPreco() {
        return preco;
    }

    public void setPreco(BigInteger preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    public void setId(int id2) {
    }

    public Bebida delete(int id2) {
        return null;
    }
    
}
