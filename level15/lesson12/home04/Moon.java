package com.javarush.test.level15.lesson12.home04;

/**
 * Created by splD on 19.10.2015.
 */
public final class Moon implements Planet
{
    private static Moon ourInstance;

    private Moon()
    {
    }

    public static synchronized Moon getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Moon();
        return ourInstance;
    }
}

