package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;
import java.util.List;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        //напишите тут ваш код
        int[] m1 = new int[5];
        for (int i = 0; i < 5; i++)
            m1[i] = i;
        int[] m2 = new int[2];
        for (int i = 0; i < 2; i++)
            m2[i] = i + 10;
        int[] m3 = new int[4];
        for (int i = 0; i < 4; i++)
            m3[i] = i + 100;
        int[] m4 = new int[7];
        for (int i = 0; i < 7; i++)
            m4[i] = i + 1000;
        int[] m5 = new int[0];
        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        return list;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
