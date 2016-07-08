package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String path = br.readLine(); //получаем путь к файлу
        List<Integer> list = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(path))); //поток чтения из файла
        String line = reader.readLine(); //сохраняем 1ю строчку, с ней идет сравнение
        while (line != null) {
            list.add(Integer.parseInt(line));
            line = reader.readLine();
        }
        //удаляем нечетные числа из списка
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)%2 != 0) {
                list.remove(i);
                i--;
            }
        }
        Collections.sort(list);
        //вывод в консоль
        for (Integer s : list) {
            System.out.println(s);
        }
    }
}
