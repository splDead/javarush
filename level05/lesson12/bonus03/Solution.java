package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;
import java.util.ArrayList;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (n <= 0)
        {
            n = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < n; i++)
                list.add(Integer.parseInt(reader.readLine()));

        int maximum = list.get(0);

        for (int i = 0; i < list.size(); i++)
        {
            if (maximum < list.get(i))
                maximum = list.get(i);
        }
        System.out.println(maximum);
    }
}
