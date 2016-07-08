package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man();
        man1.name = "Kola";
        man1.age = 30;
        man1.address = "Mitino";

        Man man2 = new Man();
        man2.name = "Dima";
        man2.age = 28;
        man2.address = "Krasnogorsk";

        Woman woman1 = new Woman();
        woman1.name = "Nika";
        woman1.age = 28;
        woman1.address = "Moskva";

        Woman woman2 = new Woman();
        woman2.name = "Ira";
        woman2.age = 25;
        woman2.address = "Derevnia";

        //выведи их на экран тут
        System.out.println(man1);
        System.out.println(man2);
        System.out.println(woman1);
        System.out.println(woman2);
    }

    //добавьте тут ваши классы
    public static class Man {
        String name;
        int age;
        String address;
    }

    public static class Woman {
        String name;
        int age;
        String address;
    }
}
