package com.javarush.test.level14.lesson06.home01;

/**
 * Created by s.goryachev on 12 Oct 2015.
 */
public class RussianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 5;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
