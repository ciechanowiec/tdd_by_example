package com;

public abstract class Money {

    abstract Money times(int multiplier);
    
    protected int amount;

    static Money dollar(int amount) {
        return new Dollar(amount);
    }

    static Money franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object object) {
        Money comparedMoney = (Money) object;
        return this.amount == comparedMoney.amount
               && this.getClass().equals(comparedMoney.getClass());        
    }    
    
}
