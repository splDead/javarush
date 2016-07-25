package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Читаем пути к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // Сохраняем их в переменные
        String path1 = bufferedReader.readLine();
        String path2 = bufferedReader.readLine();
        // Буфер больше не нужен
        bufferedReader.close();
        // Читаем оба файла
        FileInputStream fileInputStream1 = new FileInputStream(path1);
        FileInputStream fileInputStream2 = new FileInputStream(path2);
        // Сохраняем содержимое первого файла
        byte[] tempFile1 = new byte[fileInputStream1.available()];
        // Читаем первый целиком и сохраняем
        while (fileInputStream1.available() > 0) {
            int data = fileInputStream1.read(tempFile1);
        }
        // Поток записи
        FileOutputStream fileOutputStream = new FileOutputStream(path1);
        // Читаем второй файл и перезаписываем первый
        while (fileInputStream2.available() > 0) {
            fileOutputStream.write(fileInputStream2.read());
        }
        fileOutputStream.write(tempFile1); // дописываем содержимое из первого
        // Закрываем потоки
        fileInputStream1.close();
        fileInputStream2.close();
        fileOutputStream.close();
    }
}
