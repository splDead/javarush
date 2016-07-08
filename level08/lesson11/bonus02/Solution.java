package com.javarush.test.level08.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Нужно добавить в программу новую функциональность
Задача: Программа определяет, какая семья (фамилию) живёт в доме с указанным номером.
Новая задача: Программа должна работать не с номерами домов, а с городами:
Пример ввода:
Москва
Ивановы
Киев
Петровы
Лондон
Абрамовичи

Лондон

Пример вывода:
Абрамовичи
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> familys = new ArrayList<String>();
        List<String> city = new ArrayList<String>();
        while (true)
        {
            String gorod = reader.readLine();
            if (gorod.isEmpty()) break;

            city.add(gorod);

            String family = reader.readLine();
            if (family.isEmpty()) break;

            familys.add(family);
        }

        //read home number
        String ss = reader.readLine().toLowerCase();

        for (int i = 0; i < city.size(); i++) {
            if (ss.equals(city.get(i).toLowerCase())) {
                System.out.println(familys.get(i));
            }
        }
    }
}
