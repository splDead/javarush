package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // Создаем самосортирующийся словарь
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        // Поток чтения
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0) {
            char data = (char) fileInputStream.read();  // читаем символ из файла
            if (map.containsKey(data)) {                // проверяем есть ли уже такой
                map.put(data, map.get(data) + 1);       // добавляем +1
            }
            else
                map.put(data, 1);                       // если символ не встречался, добавляем его в словарь
        }
        fileInputStream.close();
        // Вывод на консоль
        for (Map.Entry<Character, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
