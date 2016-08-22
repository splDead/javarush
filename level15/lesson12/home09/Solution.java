package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            String url = reader.readLine();
            while (!url.equals(""))
            {
                int pos = url.indexOf("?");
                String tmp = url.substring(pos + 1, url.length());
                String[] mas = tmp.split("&");
                for (String s : mas)
                {
                    if (s.contains("obj"))
                    {
                        int pos1 = s.indexOf("=");
                        String doRavno = s.substring(0, pos1);
                        alert(doRavno);
                        String posle = s.substring(pos + 1, s.length());
                        if (posle.contains("."))
                        {
                            alert(Double.parseDouble(posle));
                        }
                    }
                    else
                    {

                    }
                }
//                for (String s : mas)
//                    System.out.println(s);

                url = reader.readLine();
            }

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }


    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
