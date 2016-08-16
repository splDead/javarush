package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution {

    public static void main (String[] args) throws IOException, ClassNotFoundException
    {
        Solution.B bTest = new Solution().new B("bTest");
        System.out.println(bTest.name);
        Solution.B btest2 = new Solution().new B("btest2");
        System.out.println(btest2.name);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("I:/sol.tmp");
            FileInputStream fileInputStream = new FileInputStream("I:/sol.tmp");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bTest);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            btest2 = (B) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(btest2.name);
        } catch (NotSerializableException e) {
            System.out.println("Что-то пошло не так!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class A {
        protected String name = "A";

        public A() {} // конструктор без параметров необходим для правильной работы протокола сериализации

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        public B(String name) {
            super(name);
            this.name += name;
        }
        /*
        Для правильной сериализации класс В, необходимо определить методы writeObject и readObject,
        в которых сохранить поле name из класса А.
         */
        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException
        {
            objectOutputStream.writeObject(name);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException
        {
            name = (String) objectInputStream.readObject();
        }
    }
}
