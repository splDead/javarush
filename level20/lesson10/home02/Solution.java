package com.javarush.test.level20.lesson10.home02;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
// Так как класс внутренний и нестатический, маркеруем Solution сериализуемым
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {
        // Получаем объект из потока objectStream
        Object object = objectStream.readObject();
        // Проверяем на принадлежность к классам А или В, возвращаем результат с правилльным приведением типа
        if (object instanceof A)
            return (A) object;
        else
            return (B) object;
    }
    // Класс А делаем сериализуемым
    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}
