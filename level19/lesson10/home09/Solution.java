package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        //Создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);

        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Возвращаем все как было
        System.setOut(consoleStream);

        int count = 0;
        String[] lines = outputStream.toString().split("\n");           // делим поток на массив строк по переходу на новую строку
        for (String line : lines) {
            if (count == 2) {
                System.out.println("JavaRush - курсы Java онлайн");     // при значении счетчика 2, выводим рекламу
                count = 0;                                              // обнуляем счетчик
            }
            System.out.println(line);                                   // выводим строку
            count++;                                                    // увеличиваем счетчик
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
