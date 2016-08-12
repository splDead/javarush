package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties props = new Properties();              // создаем переменную, в которой будем хранить properties

    public static void main (String [] args) throws Exception
    {
        new Solution().fillInPropertiesMap();
        System.out.println(properties);
        new Solution().save(new FileOutputStream("c:/Java/t3.properties"));
    }

    public void fillInPropertiesMap() throws Exception
    {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));   // получаем путь к файлу из консоли
        InputStream fileProperties = new FileInputStream(reader.readLine());            // создаем поток чтения
        reader.close();
        load(fileProperties);                                                           // загружаем инфу из файла с помощью нашего метода лоад
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        if (props.size() > 0) {                                                         // проверяем наличие инфы для сохранения
            props.putAll(properties);                                                   // в переменную типа Properties props добавляем из словаря данные
        }
        props.store(outputStream, "");                                                  // сохраняем на диск, без коментариев
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        props.load(inputStream);                                                        // загружаем в переменную props данные с диска

        Set<String> list = props.stringPropertyNames();                                 // сохраняем множество ключей в список

        for (String key : list) {
            properties.put(key, props.getProperty(key));                                // добавляем в словарь данные из переменной props
        }
    }
}
