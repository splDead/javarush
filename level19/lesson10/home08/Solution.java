package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Читаем с консоли
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        bufferedReader.close();
        // Читаем файл
        BufferedReader reader = new BufferedReader(new FileReader(path));

        while (reader.ready()) {
            StringBuilder stringBuilder = new StringBuilder().append(reader.readLine());
            System.out.println(stringBuilder.reverse()); // используем метод реверс СтрингБилдера
        }

        reader.close();
    }
}
