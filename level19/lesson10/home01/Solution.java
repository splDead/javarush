package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Сохраняем данные в словаре
        Map<String, Double> map = new TreeMap<String, Double>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        // Читаем построчно файл
        while (bufferedReader.ready()) {
            String[] s = bufferedReader.readLine().split(" ");              // разбиваем строку на части
            if (map.containsKey(s[0])) {                                    // проверяем есть ли запись в словаре
                map.put(s[0], Double.parseDouble(s[1]) + map.get(s[0]));    // плюсуем значение
            }
            else
                map.put(s[0], Double.parseDouble(s[1]));                    // если записи не нет, создаем ее
        }
        bufferedReader.close();
        // Вывод в консоль словаря
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
