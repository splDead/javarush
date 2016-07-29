package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();    // сохраняем путь к файлу
        while (true) {
            try {
                FileInputStream fileInputStream = new FileInputStream(path); // создаем поток чтения
            } catch (FileNotFoundException e) { // перехватываем исключение
                System.out.println(path);
                break;
            }
            path = bufferedReader.readLine();
        }
        bufferedReader.close();
    }
}
