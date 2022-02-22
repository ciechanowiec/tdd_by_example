package com;

public class Money implements Expression {

    protected String currency;    
    protected int amount;        

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public boolean equals(Object object) {
        Money comparedMoney = (Money) object;
        return this.amount == comparedMoney.amount
               && this.currency().equals(comparedMoney.currency());        
    }    

    Expression plus(Money addend) {
        return new Money(this.amount + addend.amount, this.currency);
    }

    String currency() {
        return this.currency;
    }    

    @Override
    public String toString() {
        return this.amount + " " + this.currency;
    }
    
}
