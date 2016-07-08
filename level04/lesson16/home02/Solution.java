package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());

        if (a > b && a < c && b < c)
        System.out.println(a);
        if (b > a && b < c && a < c)
        System.out.println(b);
        if (c > a && c < b && a < c)
        System.out.println(c);
        if (a > c && a < b && c < b)
            System.out.println(a);
        if (b > c && b < a && c < a)
            System.out.println(b);
        if (c > b && c < a && b < a)
            System.out.println(c);
    }
}
