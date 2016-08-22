package com.javarush.test.level14.lesson08.home09;

/**
 * Created by splD on 12.10.2015.
 */
public class Hrivna extends Money
{

    public Hrivna(double amount)
    {
        super(amount);
    }

    public String getCurrencyName()
    {
        return "HRN";
    }
}
