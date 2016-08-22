package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] list = s.toCharArray();

        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == ' ')
            {
                int a = i + 1;
                if (list[a] == ' ')
                {
                    int b = a + 1;
                    list[b] = Character.toUpperCase(list[b]);
                }
                else
                    list[a] = Character.toUpperCase(list[a]);
            }
        }
        System.out.println(list);
    }
}
