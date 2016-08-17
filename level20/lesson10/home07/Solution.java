package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;    // добавляем поле в котором храним путь к файлу

    public Solution() {}        // добавдяем конструктор без параметров

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }
    // тестовый psvm
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution("c:/Java/test.txt");
        solution.writeObject("Какие-то данные");
        solution.writeObject("Больше данных - богу данных!");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:/Java/test.tmp"));
        objectOutputStream.writeObject(solution);
        objectOutputStream.close();

        Solution solution1;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:/Java/test.tmp"));
        solution1 = (Solution) objectInputStream.readObject();
        objectInputStream.close();
        solution1.writeObject("Данные после сериализации");
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.flush();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true); // инициализируем поток, с помощью десериализонной переменной fileName
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}
