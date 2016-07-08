package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat {
    public Cat() {
        cats.add(this);
    }
    //напишите тут ваш код
    public static ArrayList cats = new ArrayList();

    public static void main(String[] args) {
        //Создай тут 10 котов
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();
        Cat cat5 = new Cat();
        Cat cat6 = new Cat();
        Cat cat7 = new Cat();
        Cat cat8 = new Cat();
        Cat cat9 = new Cat();
        Cat cat10 = new Cat();

        printCats();
    }

    public static void printCats() {
        //Добавь свой код для пункта 3 тут
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }
    }
}
