package com.javarush.test.level14.lesson08.bonus01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions() throws TypeNotPresentException
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] mas = new int[1];
            int z = mas[3];
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            byte[] b = new byte[-5];
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int i = Integer.parseInt(null);
            System.out.print(i);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "";
            String ss = s.substring(3, 5);
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new SecurityException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new UnsupportedOperationException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new ClassCastException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalArgumentException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            throw new IllegalMonitorStateException();
        } catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}


