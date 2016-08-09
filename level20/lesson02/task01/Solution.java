package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = new File("c:/Java/test.txt"); // тестовый файл
//            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            if (ivanov.name.equals(somePerson.name))
                System.out.println("Ivanov equals to somePerson");
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);         // создаем принтер

            String isNamePresent = name != null ? "yes" : "no";         // проверяем есть ли имя
            String isAssetPresent = assets != null ? "yes" : "no";      // проверяем есть ли имущество
            writer.println(isNamePresent);
            writer.println(isAssetPresent);
            // сохраняем имя
            if (name != null)
                writer.println(name);
            // если список имущества заполнен, сохраняем и его
            if (assets.size() > 0) {
                for (Asset asset : assets) {
                    writer.println(asset.getName());
                }
            }

            writer.flush();
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            // читаем строки про имя и имущество
            String isNamePresent = reader.readLine();
            String isAssetPresent = reader.readLine();
            // читаем имя
            if (isNamePresent.equals("yes"))
                name = reader.readLine();
            // читаем имущество
            if (isAssetPresent.equals("yes")) {
                while (reader.ready()) {
                    assets.add(new Asset(reader.readLine()));
                }
            }

            reader.close();
        }
    }
}
