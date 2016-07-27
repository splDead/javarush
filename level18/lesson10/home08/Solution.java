package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException
    {   // Читаем с консоли пути к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path = bufferedReader.readLine();
        // До тех пор пока не введено слово exit
        while (!"exit".equals(path)) {
            new ReadThread(path).start();       // передаем путь к файлу в нить и запускаем
            path = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        public void run() {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            try
            {   // Читаем побайтово файл
                FileInputStream fileInputStream = new FileInputStream(fileName);
                while (fileInputStream.available() > 0) {
                    int data = fileInputStream.read();
                    if (map.containsKey(data)) {            // проверяем встречался ли в словаре байт
                        map.put(data, map.get(data) + 1);   // и увеличиваем значение + 1
                    }
                    else
                        map.put(data, 1);                   // если байта еще не было, просто добавляем
                }
                fileInputStream.close();
            }
            catch (FileNotFoundException e)
            {

            }
            catch (IOException e)
            {

            }
            int key = 0;        // сохраняем сюда байт, который чаще всего встречается в файле
            int maxValue = 0;
            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                int k = pair.getKey();      // берем ключ
                int v = pair.getValue();    // берем значение
                if (v > maxValue) {         // сравневаем по значению
                    key = k;                // записываем ключ, у которого максимальное значение
                    maxValue = v;
                }
            }
            resultMap.put(fileName, key);   // в результат соответственно ключ с самым большим значение
        }
    }
}
