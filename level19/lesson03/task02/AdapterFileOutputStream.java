package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileOutputStream;
import java.io.IOException;
// берем наш интерфейс AmigoStringWriter и реализуем его методы
public class AdapterFileOutputStream implements AmigoStringWriter
{
    // сохраняем переменную стандартного потока FileOutputStream
    private FileOutputStream fileOutputStream;
    // в конструктор адаптера передаем стандартный поток
    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }
    // прокидывает методы нашего интерфейса в стандартный поток
    @Override
    public void flush() throws IOException
    {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException
    {
        fileOutputStream.close();
    }
}

