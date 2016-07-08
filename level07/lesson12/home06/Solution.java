package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandFatherFather = new Human("Kola", true, 80, null, null);
        Human grandMotherFather = new Human("Anna", false, 80, null, null);
        Human grandFatherMother = new Human("Ivan", true, 80, null, null);
        Human grandMotherMother = new Human("Shura", false, 80, null, null);
        Human father = new Human("Aleksander", true, 60, grandFatherFather, null);
        Human mother = new Human("Tonya", false, 60, grandMotherFather, grandMotherMother);
        Human child1 = new Human("Zhenya", true, 33, father, mother);
        Human child2 = new Human("Sergey", true, 28, father, mother);
        Human child3 = new Human("Ira", false, 25, father, mother);

        System.out.println(grandFatherFather);
        System.out.println(grandFatherMother);
        System.out.println(grandMotherFather);
        System.out.println(grandMotherMother);
        System.out.println(father);
        System.out.println(mother);
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
        Human father;
        Human mother;

        Human (String n, boolean s, int a, Human f, Human m) {
            name = n;
            sex = s;
            age = a;
            father = f;
            mother = m;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
