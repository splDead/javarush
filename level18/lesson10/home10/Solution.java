package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Читаем с консоли пути к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Сохраняем список частей файлов
        Map<Integer, String> map = new TreeMap<Integer, String>();
        String s = bufferedReader.readLine();
        String out = s.substring(0, s.lastIndexOf(".")); // сохраняем путь к итоговому файлу
        while (true) {
            if ("end".equals(s)) break;
            int i = Integer.parseInt(s.substring(s.lastIndexOf(".part") + 5));
            map.put(i, s);
            s = bufferedReader.readLine();
        }
        bufferedReader.close();
        // Создаем поток записи
        FileOutputStream fileOutputStream = new FileOutputStream(out);
        // Проходим по словарю
        for (Map.Entry<Integer, String> pair : map.entrySet()) {
                FileInputStream fileInputStream = new FileInputStream(pair.getValue());
                byte[] buffer = new byte[fileInputStream.available()];
                while (fileInputStream.available() > 0)
                {
                    fileInputStream.read(buffer);
                    fileOutputStream.write(buffer);
                }
                fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
