package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Сохраняем данные в словаре
        Map<String, Double> map = new HashMap<String, Double>();

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

        String key = "";
        Double value = 0.0;
        // Считаем кто богаче
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > value) {
                key = pair.getKey();
                value = pair.getValue();
            }
        }
        // Выводим имя богача в консоль
        System.out.println(key);
    }
}
