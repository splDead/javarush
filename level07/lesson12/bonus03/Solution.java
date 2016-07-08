package com.javarush.test.level07.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 20 чисел и выводит их в убывающем порядке.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array)
        {
            System.out.println(x);
        }
    }

    public static int[] sort(int[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
            tmp.add(array[i]);
        Collections.sort(tmp);
        Collections.reverse(tmp);
        for (int i = 0; i < tmp.size(); i++)
            array[i] = tmp.get(i);
        return array;
    }
}
