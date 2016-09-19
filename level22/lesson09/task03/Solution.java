package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String fileName = r.readLine();
        r.close();

        BufferedReader filereader = new BufferedReader(new FileReader(fileName));
        ArrayList<String> rawData = new ArrayList<>();

        String string;
        while ((string = filereader.readLine()) != null)
        {
            rawData.addAll(Arrays.asList(string.split(" ")));
        }
        filereader.close();

        String[] words = new String[rawData.size()];
        words = rawData.toArray(words);

        //...
        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0)
        {
            return new StringBuilder();
        }

        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, words);
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(list.get(0));
        list.remove(0);

        while (list.size()>0) {
            Collections.shuffle(list);
            for (int i = 0; i < list.size(); i++) {
                StringBuilder word = new StringBuilder(list.get(i));

                if (stringBuilder.substring((stringBuilder.length() - 1)).equals(word.reverse().substring((list.get(i).length() - 1)).toLowerCase())) {
                    stringBuilder.append(" " + list.get(i));
                    list.remove(i);
                    continue;
                }

                if (stringBuilder.toString().substring(0,1).toLowerCase().equals(list.get(i).substring(list.get(i).length()-1).toLowerCase()))
                {
                    stringBuilder.reverse().append(" "+word);
                    stringBuilder.reverse();
                    list.remove(i);
                    continue;
                }
            }
        }

        return stringBuilder;
    }
}