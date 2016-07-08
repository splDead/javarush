package com.javarush.test.level14.lesson06.home01;

/**
 * Created by s.goryachev on 12 Oct 2015.
 */
public class UkrainianHen extends Hen
{
    int getCountOfEggsPerMonth()
    {
        return 1;
    }

    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
