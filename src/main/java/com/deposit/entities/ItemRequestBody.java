package com.deposit.entities;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemRequestBody {
    private Integer units;

    private Integer beverageId;

    private BigInteger unitPrice;

    public ItemRequestBody(){}

    @JsonCreator
    public ItemRequestBody(
        @JsonProperty("units") Integer units,
        @JsonProperty("beverageId") Integer beverageId
    ) {
        this.units = units;
        this.beverageId = beverageId;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getBeverageId() {
        return beverageId;
    }

    public void setBeverageId(Integer beverageId) {
        this.beverageId = beverageId;
    }
}
