package com;

public abstract class Money {

    protected String currency;    
    protected int amount;    
    abstract Money times(int multiplier);    

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    static Money franc(int amount) {
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money comparedMoney = (Money) object;
        return this.amount == comparedMoney.amount
               && this.getClass().equals(comparedMoney.getClass());        
    }    

    String currency() {
        return this.currency;
    }
    
}
