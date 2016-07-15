package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
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

//        PrintStream stream = new PrintStream(outputStream);
        //создаем адаптер к классу PrintStream и устанавливаем его как текущий System.out
        System.setOut(new PrintStream(outputStream));

        testString.printSomething();

//        String result = outputStream.toString().replaceAll("te", "??");
        //Возвращаем все как было
        System.setOut(consoleStream);
        //Преобразовываем записанные в наш ByteArray данные в строку, заменяя все подстроки "te" на "??"
        System.out.println(outputStream.toString().replaceAll("te", "??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}
