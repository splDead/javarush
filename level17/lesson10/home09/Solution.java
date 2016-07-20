package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException
    {   // Буфер для получения путей к файлам
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String path1 = bufferedReader.readLine();
        String path2 = bufferedReader.readLine();
        bufferedReader.close();
        // Буферы чтения из файла
        BufferedReader reader1 = new BufferedReader(new FileReader(path1));
        BufferedReader reader2 = new BufferedReader(new FileReader(path2));

        while (reader1.ready()) {
            allLines.add(reader1.readLine());
        }
        reader1.close();

        while (reader2.ready()) {
            forRemoveLines.add(reader2.readLine());
        }
        reader2.close();
        // Это магия
        new Solution().joinData();
    }

    public void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))   // сравнение двух списков
            allLines.removeAll(forRemoveLines);     // при совпадении, из первого списка удаляется содержимое второго
        else {
            allLines.clear();                       // при неСовпадении, первый список очищается
            throw new CorruptedDataException();     // и выкидывается исключение
        }
    }
}
