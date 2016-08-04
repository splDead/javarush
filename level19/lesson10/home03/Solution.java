package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        // Считываем файл построчно
        while (bufferedReader.ready()) {
            String [] tmp = bufferedReader.readLine().split(" ");               // разбиваем строчку на массив
            String name = "";
            for (int i = 0; i < tmp.length - 3; i++) {                          // сохраняем имя, минус 3 ячейки с конца массива, в которых хранится дата
                name += tmp[i] + " ";
            }
            int year = Integer.parseInt(tmp[tmp.length - 1]);                   // год рождения, последняя ячейка
            int month = Integer.parseInt(tmp[tmp.length-2])-1;                  // месяц рождения, предпоследняя
            int day = Integer.parseInt(tmp[tmp.length-3]);                      // день рождения, предпредпоследняя
            Date birthDay = new GregorianCalendar(year, month, day).getTime();  // получаем дату рождения
            PEOPLE.add(new Person(name.trim(), birthDay));                      // создаем человека, имя чистится от лишнего пробела
        }
        bufferedReader.close();
    }
}
