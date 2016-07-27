package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Считываем с консоли путь к файлу и сохраняем его в переменную
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        bufferedReader.close();
        // id для поиска
        int id = Integer.parseInt(args[0]);
        // Построчно сохраняем содержимое файла в списке
        List<String> list = new ArrayList<String>();
        // Читаем файл
        BufferedReader reader = new BufferedReader(new FileReader(path));

        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close();
        // Поиск по id
        for (String s : list) {
            String[] strings = s.split(" ");            // берем строку, переводим ее в массив
            if (Integer.parseInt(strings[0]) == id) {   // ищем в первой ячейки id
                System.out.println(s);                  // выводим результат в консоль
            }
        }
    }
}
