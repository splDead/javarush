package com.javarush.test.level15.lesson12.home04;

/**
 * Created by splD on 19.10.2015.
 */
public final class Sun implements Planet
{
    private static Sun ourInstance;

    private Sun()
    {
    }

    public static synchronized Sun getInstance()
    {
        if (ourInstance == null)
            ourInstance = new Sun();
        return ourInstance;
    }
}
