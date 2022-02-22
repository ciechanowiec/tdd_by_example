/** 
 * # TDD by Example. Part I
 * 
 * ## Basic Info
 * This repository containts coding exercise from the book Test Driven Development. By Example (2003)
 * written by Kent Beck. The repository embraces only Part I (The Money Example) of the mentioned book.
 * 
 * | Parameter                         | Data                                        |
 * | :-------------------------------: | :-----------------------------------------: |
 * | Date of creation:                 | February 2022                               |
 * | Technologies used:                | Java SE, JUnit                              |
 * | Time spent to create the program: | ~2 days                                     |
 * | Author:                           | Herman Ciechanowiec, herman@ciechanowiec.eu |
 * | License:                          | MIT No Attribution License                  |
 * 
 * ## To-Do List
 * - [x] $5 + 10 CHF = $10 if rate is 2:1
 * - [x] $5 + $5 = $10
 * - [x] Return Money from $5 + $5
 * - [x] Bank.reduce(Money)
 * - [x] Reduce Money with conversion
 * - [x] Reduce(Bank, String)
 * - [x] $5 * 2 = $10
 * - [x] Make “amount” private
 * - [x] Dollar side effects?
 * - [x] equals()
 * - [x] hashCode()
 * - [x] 5 CHF * 2 = 10 CHF		
 * - [x] Dollar/Franc duplication
 * - [x] Common equals
 * - [x] Common times
 * - [x] Compare Francs with Dollars
 * - [x] Currency?
 * - [x] Delete testFrancMultiplication?
 * - [x] Sum.plus
 * - [x] Expression.times
 * 
 * ## License
 * The program is subject to MIT No Attribution License
 * 
 * Copyright © 2022 Herman Ciechanowiec
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this
 * software and associated documentation files (the "Software"), to deal in the Software
 * without restriction, including without limitation the rights to use, copy, modify,
 * merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so.
 * 
 * The Software is provided "as is", without warranty of any kind, express or implied,
 * including but not limited to the warranties of merchantability, fitness for a
 * particular purpose and noninfringement. In no event shall the authors or copyright
 * holders be liable for any claim, damages or other liability, whether in an action
 * of contract, tort or otherwise, arising from, out of or in connection with the
 * Software or the use or other dealings in the Software.
 * 
 * */

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
