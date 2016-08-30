package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        List<String> list = new ArrayList<>();
        while (reader.ready()) {
            Collections.addAll(list, reader.readLine().split("\\s+"));
        }
        reader.close();

        Map<String, String> pairs = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            String usual = list.get(i);
            String usualreverse = new StringBuilder(usual).reverse().toString();

            {
                for (int j = i + 1; j < list.size(); j++)
                {
                    // 1 если такой ключ уже есть
                    if (pairs.containsKey(usual)) {continue;}
                    // 2 если такой ключ, только перевернутый, уже есть, т.е повтор
                    if (pairs.containsKey(usualreverse)) {continue;}

                    String reverse = new StringBuilder(list.get(j)).reverse().toString();

                    //2 условие если строка реверсивна следующей
                    if (usual.equals(reverse))
                    {
                        pairs.put(usual, list.get(j));
                    }
                }
            }
        }

        for (Map.Entry<String, String> entry : pairs.entrySet()) {
            Pair pair = new Pair();
            pair.first = entry.getKey();
            pair.second = entry.getValue();
            result.add(pair);
        }

        for (Pair p : result) {
            System.out.println(p.toString());
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
