package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human child1 = new Human("Sergey", true, 28, new ArrayList<Human>());
        Human child2 = new Human("Ira", false, 25, new ArrayList<Human>());
        Human child3 = new Human("Zhenya", true, 33, new ArrayList<Human>());
        ArrayList<Human> children = new ArrayList<Human>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        Human father = new Human("Sasha", true, 60, children);
        Human mother = new Human("Tonya", false, 55, children);
        ArrayList<Human> childfather = new ArrayList<Human>();
        childfather.add(father);
        ArrayList<Human> childmother = new ArrayList<Human>();
        childmother.add(mother);
        Human grandFatherFather = new Human("Kola", true, 77, childfather);
        Human grandMotherFather = new Human("Anna", false, 74, childfather);
        Human grandFatherMother = new Human("Ivan", true, 77, childmother);
        Human grandMotherMother = new Human("Shura", false, 74, childmother);
        System.out.println(grandFatherFather);
        System.out.println(grandMotherFather);
        System.out.println(grandFatherMother);
        System.out.println(grandMotherMother);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private ArrayList<Human> children;

        Human (String n, boolean s, int a, ArrayList<Human> c) {
            name = n;
            sex = s;
            age = a;
            children = c;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
