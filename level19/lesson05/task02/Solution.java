package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // буфер, который считывает путь к файлу
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathSource = bufferedReader.readLine();
        // буфер для построчного чтения файла
        BufferedReader br = new BufferedReader(new FileReader(pathSource));
        // построчно сохраняем в список
        List<String> list = new ArrayList<String>();
        while (br.ready()) {
            list.add(br.readLine());
        }
        int countWordWorld = 0; // счетчик нужных слов
        // перебор списка
        for (String s : list) {
            String [] strMas = s.split("\\W+"); // разделяем строку в массив по любым разделителям
            for (String s1 : strMas) {
                if (s1.equals("world"))
                    countWordWorld++;
            }
        }
        // вывод результата и закрытие потоков
        System.out.println(countWordWorld);
        bufferedReader.close();
        br.close();
    }
}
