package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Читаем с консоли пути к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Сохраняем их в переменные
        String path1 = bufferedReader.readLine();
        String path2 = bufferedReader.readLine();
        String path3 = bufferedReader.readLine();
        // Буфер чтения более не нужен
        bufferedReader.close();
        // Потоки чтения из файла
        FileInputStream fileInputStream1 = new FileInputStream(path2);
        FileInputStream fileInputStream2 = new FileInputStream(path3);
        // Поток записи
        FileOutputStream fileOutputStream = new FileOutputStream(path1);
        // Читаем из второго файла
        while (fileInputStream1.available() > 0) {
            fileOutputStream.write(fileInputStream1.read());
        }
        // Читаем из третьего файла
        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        // Закрываем за собой потоки
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
