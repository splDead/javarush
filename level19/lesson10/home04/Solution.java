package com.javarush.test.level19.lesson10.home04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException
    {   // Получаем путь к файлу
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        bufferedReader.close();
        // Читаем построчно файл
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (reader.ready()) {
            int count = 0;                          // счетчик вхождений
            String line = reader.readLine();        // получаем строку из файла
            String[] str = line.split("\\s+");      // делим по пробелам на массив
            for (String s : str) {                  // перебор массива
                for (String word : words) {
                    if (word.equals(s)) count++;    // сравниваем слово из контрольного списка с элементом массива
                }
            }
            if (count == 2)                         // при двух совпадениях выводим строку из файла в консоль
                System.out.println(line);
        }
        reader.close();
    }
}
