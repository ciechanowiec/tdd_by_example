package com;

public class Money implements Expression {

    protected int amount;        
    protected String currency;    

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

    public Expression times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
    }

    @Override
    public boolean equals(Object object) {
        Money comparedMoney = (Money) object;
        return this.amount == comparedMoney.amount
               && this.currency().equals(comparedMoney.currency());        
    }    

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    String currency() {
        return this.currency;
    }    

    public Money reduce(Bank bank, String to) {
        int rate = bank.rate(currency, to);
        return new Money(amount / rate, to);
    }    

    @Override
    public String toString() {
        return this.amount + " " + this.currency;
    }
    
}
