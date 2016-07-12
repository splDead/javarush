package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // буфер для чтения из консоли
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathSource = bufferedReader.readLine();  // путь к файлу-исходнику
        String pathDest = bufferedReader.readLine();    // путь к файлу назначения
        FileInputStream fileInputStream = new FileInputStream(pathSource);  // поток чтения
        FileOutputStream fileOutputStream = new FileOutputStream(pathDest); // поток записи
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (data == 46) {   // проверяем байт по таблице ASCII-символов
                data = 33;      // меняем "." на знак "!"
            }
            fileOutputStream.write(data);
        }
        // закрываем потоки
        bufferedReader.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
