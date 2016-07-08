package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int  maximum = 0;
        int  minimum = 0;

        //напишите тут ваш код
        Integer[] mas = new Integer[20];
        //ArrayList<Integer> list = new ArrayList<Integer>(); //create list
        //заполняю список
        //for (int i = 0; i < 20; i++)
        //    list.add(Integer.parseInt(reader.readLine()));
        for (int i = 0; i < 20; i++)
            mas[i] = Integer.parseInt(reader.readLine());
        //вычисляю максимум
        for (int i = 0; i < mas.length; i++) {
            maximum = mas[0];
            if (maximum < mas[i])
                maximum = mas[i];
        }
        //вычисляю минимум
        for (int i = 0; i < mas.length; i++) {
            minimum = mas[0];
            if (minimum > mas[i])
                minimum = mas[i];
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
