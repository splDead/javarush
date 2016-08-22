package com.javarush.test.level15.lesson12.home04;

/**
 * Created by splD on 19.10.2015.
 */
public final class Earth implements Planet
{
    private static Earth ourInstance;

    private Earth()
    {
    }

    public static synchronized Earth getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Earth();
        return ourInstance;
    }
}
