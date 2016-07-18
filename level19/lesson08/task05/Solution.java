package com.javarush.test.level19.lesson08.task05;

/* Дублируем текст
Считайте с консоли имя файла
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна дублировать вывод всего текста в файл, имя которого вы считали
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Закройте поток файла

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException
    {   // Получаем путь к файлу
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        // Закрываем поток
        bufferedReader.close();
        // Поток записи в файл
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        // Сохраняем оригинальный PrintStream
        PrintStream consoleStream = System.out;
        // Массив для хранения нашего потока PrintStream
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        // Создаем свой поток
        PrintStream stream = new PrintStream(outputStream);

        System.setOut(stream);
        // Заполняем наш поток какими-то данными
        testString.printSomething();
        // Возвращаем все как было
        System.setOut(consoleStream);
        // Вывод в консоль и в файл
        System.out.println(outputStream.toString());
        fileOutputStream.write(outputStream.toString().getBytes());
        // Закрываем поток записи в файл
        fileOutputStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

