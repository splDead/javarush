package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("c:/Java/test.txt");
//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();    // тестовый юзер ван
            user1.setFirstName("Nickolay");
            user1.setLastName("Loschinin");
            user1.setBirthDate(new GregorianCalendar(1983, 11, 31).getTime());
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            User user2 = new User();    // тестовый юзер ту
            user2.setFirstName("Sergey");
            user2.setLastName("Goryachev");
            user2.setBirthDate(new GregorianCalendar(1987, 0, 26).getTime());
            user2.setMale(true);
            user2.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.users.get(0).getFirstName().equals(loadedObject.users.get(0).getFirstName()))  // проверяем что загрузили то самое
                System.out.println(loadedObject.users.get(0).toString());

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            // проверяем что список юзеров заполнен
            if (users != null) {
                for (User user : users) {   // для каждого юзера создаем 5 строковых переменных, в которые пишем значения
                    String isFirstName = user.getFirstName() != null ? user.getFirstName() : "no";  // имя
                    String isLastName = user.getLastName() != null ? user.getLastName() : "no";     // фамилия
                    String isBirthDate = user.getBirthDate() != null ? new SimpleDateFormat("dd MM yyyy").format(user.getBirthDate()) : "no";   // дата рождения в привычном формате
                    String isMale = user.isMale() ? "yes" : "no";   // пол юзера, мужик - да
                    String isCountry = user.getCountry() != null ? user.getCountry().getDisplayedName() : "no"; // страна рождения вероятно

                    writer.println(isFirstName);
                    writer.println(isLastName);
                    writer.println(isBirthDate);
                    writer.println(isMale);
                    writer.println(isCountry);

                    writer.flush();
                }
            }
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            while (reader.ready()) {
                // Создаем 5 переменных, из которых будем собирать юзера обратно
                String isFirstName = reader.readLine();
                String isLastName = reader.readLine();
                String isBirthDate = reader.readLine();
                String isMale = reader.readLine();
                String isCountry = reader.readLine();
                // Начинаем сбор гомункула
                User user = new User();

                if (!isFirstName.equals("no")) {
                    user.setFirstName(isFirstName);             // имя
                }
                if (!isLastName.equals("no")) {
                    user.setLastName(isLastName);               // фамилия
                }
                if (!isBirthDate.equals("no")) {
                    String[] date = isBirthDate.split(" ");     // распарсим строку с датой
                    int year = Integer.parseInt(date[2]);       // получаем год
                    int month = Integer.parseInt(date[1])-1;    // месяц, не забываем что он считается с 0
                    int day = Integer.parseInt(date[0]);        // день
                    Date birthDay = new GregorianCalendar(year, month, day).getTime();  // собираем дату по грегорианскому календарю
                    user.setBirthDate(birthDay);                // устанавливаем ДР у гомункула
                }
                if (isMale.equals("yes")) {
                    user.setMale(true);                         // пол, тру конечно же мужик
                }
                else
                    user.setMale(false);
                if (!isCountry.equals("no")) {
                    switch (isCountry)                          // смотрим не гастр ли наш гомункул
                    {
                        case "Ukraine":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "Russia":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        default:
                            user.setCountry(User.Country.OTHER);
                            break;
                    }
                }
                users.add(user);                                // гомункул собран, добавляем в список
            }
            reader.close();
        }
    }
}
