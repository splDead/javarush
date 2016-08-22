package com.javarush.test.level09.lesson11.home09;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> tmp = new HashMap<>();
        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        Cat cat3 = new Cat("cat3");
        Cat cat4 = new Cat("cat4");
        Cat cat5 = new Cat("cat5");
        Cat cat6 = new Cat("cat6");
        Cat cat7 = new Cat("cat7");
        Cat cat8 = new Cat("cat8");
        Cat cat9 = new Cat("cat9");
        Cat cat10 = new Cat("cat10");
        tmp.put(cat1.name, cat1);
        tmp.put(cat2.name, cat2);
        tmp.put(cat3.name, cat3);
        tmp.put(cat4.name, cat4);
        tmp.put(cat5.name, cat5);
        tmp.put(cat6.name, cat6);
        tmp.put(cat7.name, cat7);
        tmp.put(cat8.name, cat8);
        tmp.put(cat9.name, cat9);
        tmp.put(cat10.name, cat10);
        return tmp;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> tmp = new HashSet<>();
        for (Cat value : map.values()) {
            tmp.add(value);
        }
        return tmp;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat " + this.name;
        }
    }


}
