package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    // делаем адаптер Scanner к PersonScanner, для этого реализуем наш интерфейс
    public static class PersonScannerAdapter implements PersonScanner {
        // сохраняем сканер
        private Scanner scanner;
        // в конструктор адаптера передаем сканер
        public PersonScannerAdapter (Scanner scanner) {
            this.scanner = scanner;
        }
        // реализуем методы нашего интерфейса
        @Override
        public Person read() throws IOException
        {   // сканируем строку
            String line = scanner.nextLine();/*Иванов Иван Иванович 31 12 1950*/
            String[] splitStr = line.split("\\s+"); //делим строку, через пробелы
            String firstName = splitStr[1];     // имя
            String middleName = splitStr[2];    // отчество
            String lastName = splitStr[0];      // фамилия
            Date birthDate=null;
            try // парсим ДР
            {
                int day = Integer.parseInt(splitStr[3]);
                int month = (Integer.parseInt(splitStr[4]))-1; // месяц -1, ибо компы считают с нуля, в отличии от людей
                int year = Integer.parseInt(splitStr[5]);
                birthDate = (new GregorianCalendar(year,month,day).getTime()); // получаем ДР

            }
            catch (Exception e)
            {
            }
            // на выходе создается новый Person из распарсенной строки
            return new Person(firstName, middleName, lastName, birthDate);
        }

        @Override
        public void close() throws IOException
        {
            this.scanner.close();
        }
    }
    // проверочный мейн
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner("Иванов Иван Иванович 31 12 1950"); // пример для парса

        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(scanner);

        System.out.println(personScannerAdapter.read());

    }
}
