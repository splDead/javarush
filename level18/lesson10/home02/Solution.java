package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Создаем поток чтения, аргумент первый из мейна
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        // Счетчики символов и пробелов
        int countChar = 0;
        int countSpace = 0;

        while (fileInputStream.available() > 0) {
            if (fileInputStream.read() == 32)   // Проверяем считанный байт с таблицей ASCII и считаем пробелы
                countSpace++;
            countChar++;
        }
        fileInputStream.close();
        // Вывод в консоль соотношение пробелов к символам с 2мя знаками после запятой
        System.out.println(String.format(Locale.US, "%.2f", (double) countSpace/countChar*100));
    }
}
