package com;

public class Money {

    protected int amount;

    @Override
    public boolean equals(Object object) {
        Money comparedMoney = (Money) object;
        return this.amount == comparedMoney.amount
               && this.getClass().equals(comparedMoney.getClass());        
    }    
    
}
