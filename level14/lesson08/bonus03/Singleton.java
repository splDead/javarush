package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by s.goryachev on 30.06.2016.
 */
public class Singleton
{
    //переменная в которой хранится экземпляр класса
    private static final Singleton instance = new Singleton();

    private Singleton() {} //приватный конструктор

    //метод возвращающий экземпляр класса Синглтон
    public static Singleton getInstance() {
        return instance;
    }
}
