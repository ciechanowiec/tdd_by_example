package com;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MoneyTest {

    @Test
    public void testMiltiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));        
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMiltiplication() {
        Money five = Money.franc(5);        
        assertEquals(Money.franc(10), five.times(2));        
        assertEquals(Money.franc(15), five.times(3));
    }

    public void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));                
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
    }
    
    @Test 
    public void testSimpleAddition() {        
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

}
