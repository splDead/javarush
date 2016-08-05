package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));    // получаем файл источник
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));    // файл назначения

        while (reader.ready()) {
            String[] line = reader.readLine().trim().split("\\s+");             // делим полученную строку на отдельные слова
            for (String s : line) {
                if (s.matches(".*[0-9].*"))                                     // проверяем через регулярное выражение, есть ли в слове цифра
                    writer.write(s + " ");                                      // пишем во второй файл
            }
        }
        reader.close();
        writer.close();
    }
}
