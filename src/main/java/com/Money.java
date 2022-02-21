package com;

public class Money {

    protected int amount;

    @Override
    public boolean equals(Object object) {
        Money comparedMoeny = (Money) object;
        return this.amount == comparedMoeny.amount;        
    }    
    
}
