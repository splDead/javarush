package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        // буфер чтения с консоли
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // пути к файлам
        String pathSource = bufferedReader.readLine();
        String pathDest = bufferedReader.readLine();
        // закрываем буфер
        bufferedReader.close();
        // буфер чтения файла
        BufferedReader reader = new BufferedReader(new FileReader(pathSource));
        FileOutputStream fileOutputStream = new FileOutputStream(pathDest);
        // читаем построчно, храним в списке
        List<String> list = new ArrayList<String>();
        while (reader.ready()) {
            list.add(reader.readLine());
        }
        reader.close(); //закрываем буфер чтения файла
        // результирующая строка
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i).replaceAll("\\p{Punct}", ""); // заменяем знаки пунктуации на ничего
            stringBuilder.append(str);
        }
        // записываем в файл и закрываем поток
        fileOutputStream.write(stringBuilder.toString().getBytes());
        fileOutputStream.close();
    }
}
