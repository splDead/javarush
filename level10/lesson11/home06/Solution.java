package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        String name;
        int age;
        boolean sex;
        int height;
        int weight;
        int foot;

        Human (String name)
        {
            this.name = name;
        }
        Human (String name, int age)
        {
            this.name = name;
            this.age = age;
        }
        Human (String name, int age, boolean sex)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }
        Human (String name, int age, boolean sex, int height)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
        }
        Human (String name, int age, boolean sex, int height, int weight)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }
        Human (String name, int age, boolean sex, int height, int weight, int foot)
        {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
            this.foot = foot;
        }
        Human (String name, int height, int age, boolean sex, int weight, int foot)
        {
            this.name = name;
            this.height = height;
            this.age = age;
            this.sex = sex;
            this.weight = weight;
            this.foot = foot;
        }
        Human (String name, int height, int weight, int age, boolean sex, int foot)
        {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.age = age;
            this.sex = sex;
            this.foot = foot;
        }
        Human (String name, int height, int weight, int foot, int age, boolean sex)
        {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.foot = foot;
            this.age = age;
            this.sex = sex;
        }
        Human (String name, int height, int weight, int foot, int age)
        {
            this.name = name;
            this.height = height;
            this.weight = weight;
            this.foot = foot;
            this.age = age;
        }
    }
}
