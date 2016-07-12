package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {   // получаем пути к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String pathSource = bufferedReader.readLine();
        String pathDest = bufferedReader.readLine();
        // буфер для построчного чтения файла
        BufferedReader br = new BufferedReader(new FileReader(pathSource));
        // поток для записи в файл результата
        FileOutputStream fileOutputStream = new FileOutputStream(pathDest);
        // список для данных из файла
        List<String> list = new ArrayList<String>();
        // результат
        StringBuilder stringBuilder = new StringBuilder();
        // считываем файл
        while (br.ready()) {
            list.add(br.readLine());
        }
        // проход по списку и отсев лишнего
        for (String s : list) {
            String [] strMas = s.split("\\s+"); // разделяем строку по пробелам
            for (int i = 0; i < strMas.length; ) {
                try {
                    int num = Integer.parseInt(strMas[i]); // попытка преобразовать строку в число
                    stringBuilder.append(num).append(" "); // заносим в результат
                    i++;
                } catch (Exception e) {
                    i++;
                }
            }
        }
        // преобразуем результат к строке, убираем последний пробел, преобразуем в массив
        fileOutputStream.write(stringBuilder.toString().trim().getBytes());
        // закрываем потоки
        bufferedReader.close();
        br.close();
        fileOutputStream.close();
    }
}
