package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        // Делим массив на строки и числа
        for (String s : array) {
            if (isNumber(s))
                list1.add(Integer.parseInt(s));
            else
                list2.add(s);
        }

        // Пузырьком сортируем числа в обратном порядке
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                int num = list1.get(i);
                if (num < list1.get(j)) {
                    list1.set(i, list1.get(j));
                    list1.set(j, num);
                }
            }
        }

        // Пузырьком сортируем слова по алфавиту
        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                String s = list2.get(i);
                if (isGreaterThan(s, list2.get(j))) {
                    list2.set(i, list2.get(j));
                    list2.set(j, s);
                }
            }
        }

        // На основе списков переписываем исходный массив
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                array[i] = list1.get(0).toString();
                list1.remove(0);
            }
            else {
                array[i] = list2.get(0);
                list2.remove(0);
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
