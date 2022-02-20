package com;

public class Dollar {

    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        return result;
    }

    @Override
    public boolean equals(Object object) {
        Dollar comparedDollar = (Dollar) object;
        return this.amount == comparedDollar.amount;        
    }
    
}
