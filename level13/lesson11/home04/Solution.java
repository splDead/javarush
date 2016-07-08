package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String path = reader.readLine(); //сохраняем путь к файлу
        while (true) {
            String temp = reader.readLine();
            stringBuilder.append(temp).append("\r\n"); //добаляем переход на новую строку
            if("exit".contains(temp)) break; //условие выхода из цикла, exit включается в файл
        }
        FileOutputStream fos = new FileOutputStream(path); //создаем поток вывода
        fos.write(stringBuilder.toString().getBytes()); //пишем его
        //закрываем потоки
        fos.close();
        reader.close();
    }
}
