package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args)
    {
        A a1 = new A(1, 2);
        A a2 = null;

        B b1 = new B(3, 4, "b1");
        B b2 = null;

        C c1 = new C(5, 6, "c1");
        C c2 = null;
        try
        {
            a2 = a1.clone();
//            b2 = b1.clone();
            c2 = c1.clone();

            System.out.println(a1);
            System.out.println(a2);

            System.out.println(b1);

            System.out.println(c1);
            System.out.println(c2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        // Тут вполне обычное клонирование 2 полей класса и создание нового экземпляра
        @Override
        protected A clone() throws CloneNotSupportedException
        {
            return new A(this.getI(), this.getJ());
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        // Вместо процедуры клонирования, выкидываем эксепшен
        @Override
        protected B clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException("Не сегодня");
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        // Опять же стандартное клонирование с созданием нового экземпляра
        @Override
        protected C clone() throws CloneNotSupportedException
        {
            return new C(this.getI(), this.getJ(), this.getName());
        }
    }
}
