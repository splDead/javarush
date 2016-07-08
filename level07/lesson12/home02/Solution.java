package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> list = new ArrayList<Integer>(); //создаем список
        //System.out.print("Введите число N: ");
        int n = Integer.parseInt(reader.readLine()); //количество строк
        //System.out.print("Введите число M: ");
        int m = Integer.parseInt(reader.readLine()); //вспомогательное число из задачи
        //System.out.println("Введите " + n + " чисел:");
        for (int i = 0; i < n; i++) //заполняем список
            list.add(Integer.parseInt(reader.readLine()));
        //переносим строки из начала в конец
        for (int i = 0; i < m; i++) {
            int tmp = list.get(0);
            list.remove(0);
            list.add(tmp);
        }
        //выводим список
        for (Integer i : list)
            System.out.println(i);
    }
}
