package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Получаем пути к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bufferedReader.readLine();
        String path2 = bufferedReader.readLine();
        bufferedReader.close();
        // Ридер файла
        BufferedReader reader = new BufferedReader(new FileReader(path1));
        // Храним построчно
        List<String> list = new ArrayList<String>();
        // Читаем файлик
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        // Поток записи
        FileOutputStream fileOutputStream = new FileOutputStream(path2);
        // Проходим по списку
        for (String s : list) {
            String [] mas = s.split(" "); // разделяем строку по пробелу
            for (String s1 : mas) {
                try {
                    int result = (int)Math.round(Double.parseDouble(s1));   // пробуем округлить
                    fileOutputStream.write((result + " ").getBytes());      // пишем через пробел во второй файл
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        fileOutputStream.close();
    }
}
