package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Передаем в поток чтения первый параметр из мейна
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        // Счетчик букв
        int count = 0;

        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            Pattern p = Pattern.compile("[a-zA-Z]");                // Создаем паттерн из английских букв
            Matcher m = p.matcher(String.valueOf((char) data));     // Проверяем матчером
            if (m.matches()) count++;
//            if (String.valueOf((char) fileInputStream.read()).matches("[a-zA-Z]")) count++; // Супер укороченная запись
        }
        fileInputStream.close();    // Закрываем поток чтения из файла

        System.out.println(count);  // Вывод в консоль количества букв из файла
    }
}
