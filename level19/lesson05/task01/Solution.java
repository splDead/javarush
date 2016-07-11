package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // буфер чтения
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathSource = bufferedReader.readLine(); // путь к исходному файлу
        String pathDest = bufferedReader.readLine(); // путь к файлу назначения
        FileInputStream fileInputStream = new FileInputStream(pathSource);
        FileOutputStream fileOutputStream = new FileOutputStream(pathDest);
        byte[] mas = new byte[fileInputStream.available()]; // читаем сразу весь файл целиком
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read(mas);
            // пишем байты начиная с 1 через один
            for (int i = 1; i < mas.length; ) {
                fileOutputStream.write(mas[i]);
                i += 2;
            }
        }
        // закрываем потоки
        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
