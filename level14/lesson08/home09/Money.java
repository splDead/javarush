package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double bablo;

    public Money(double amount)
    {
        this.bablo = amount;
    }

    public double getAmount()
    {
        return bablo;
    }

    public abstract String getCurrencyName();
}

