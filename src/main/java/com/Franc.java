package com;

public class Franc {    

    private int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
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
        Franc comparedFranc = (Franc) object;
        return this.amount == comparedFranc.amount;        
    }   

}
