package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        Map<Integer, Integer> list = new HashMap<>();
        while (inputStream.available() > 0) {
            int k = inputStream.read();
            if (list.containsKey(k)) {
                int value = list.get(k);
                list.put(k, ++value);
            }
            else
                list.put(k, 1);
        }
        inputStream.close();
        int tempValue=0;
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            if(tempValue<l.getValue())
                tempValue = l.getValue();
        }
        for(Map.Entry<Integer, Integer> l:list.entrySet()){
            if(l.getValue()==tempValue)
                System.out.print(l.getKey()+" ");
        }
    }
}
