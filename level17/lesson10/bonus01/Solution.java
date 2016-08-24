package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException
    {
        //start here - начни тут
        String command = args[0];

        SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (command) {
            case ("-c"): {
                // Получаем имя, может состоять из более чем одного слова
                String name = "";
                for (int i = 1; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }

                Date bd = sdfIn.parse(args[args.length - 1]); // др человека

                // Проверяем пол
                if (args[args.length - 2].equals("м"))
                    allPeople.add(Person.createMale(name.trim(), bd));
                else
                    allPeople.add(Person.createFemale(name.trim(), bd));

                // Вывод в консоль последнего добавленного человека
                System.out.println(allPeople.size() - 1);
            }
            break;

            case ("-u"): {
                int id = Integer.parseInt(args[1]); // получаем id человека

                // Получаем имя, может состоять из более чем одного слова
                String name = "";
                for (int i = 2; i < args.length - 2; i++) {
                    name += args[i] + " ";
                }

                Sex sex = args[args.length - 2].equals("м") ? Sex.MALE : Sex.FEMALE;    // проверяем пол человека
                Date bd = sdfIn.parse(args[args.length - 1]);                           // др человека

                // Обновляем данные
                allPeople.get(id).setName(name.trim());
                allPeople.get(id).setSex(sex);
                allPeople.get(id).setBirthDay(bd);
            }
            break;

            case ("-d"): {
                int id = Integer.parseInt(args[1]);
                allPeople.get(id).setBirthDay(null); // логическое удаление - обнуление даты рождения
            }
            break;

            case ("-i"): {
                // Вывод в консоль информации по id
                int id = Integer.parseInt(args[1]);
                String name = allPeople.get(id).getName();
                String sex = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
                Date bd = allPeople.get(id).getBirthDay();
                System.out.printf("%s %s %s\n", name, sex, sdfOut.format(bd));
            }
            break;
        }
    }
}
