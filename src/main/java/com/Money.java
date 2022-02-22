package com;

public class Money {

    protected String currency;    
    protected int amount;        

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

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public boolean equals(Object object) {
        Money comparedMoney = (Money) object;
        return this.amount == comparedMoney.amount
               && this.currency().equals(comparedMoney.currency());        
    }    


    String currency() {
        return this.currency;
    }    

    public String toString() {
        return this.amount + " " + this.currency;
    }
    
}
