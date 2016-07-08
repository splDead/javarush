package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }
    //проверочный мейн
    public static void main (String[] args) {

        IncomeData incomeData = new IncomeData()
        {
            @Override
            public String getCountryCode()
            {
                return "UA";
            }

            @Override
            public String getCompany()
            {
                return "JavaRush Ltd.";
            }

            @Override
            public String getContactFirstName()
            {
                return "Ivan";
            }

            @Override
            public String getContactLastName()
            {
                return "Ivanov";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return 435;
            }

            @Override
            public int getPhoneNumber()
            {
                return 501234567;
            }
        };

        Customer customer = new IncomeDataAdapter(incomeData);
        Contact contact = new IncomeDataAdapter(incomeData);

        System.out.println(customer.getCompanyName());
        System.out.println(customer.getCountryName());
        System.out.println(contact.getName());
        System.out.println(contact.getPhoneNumber());
    }
    // реализуем нужные интерфейсы
    public static class IncomeDataAdapter implements Customer, Contact {
        //сохраняем исходные данные
        private IncomeData incomeData;
        // в конструктор передаем исходник
        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }
        // реализуем методы интерфейсов, использую исходник
        @Override
        public String getName()
        {   // фамилия, имя
            return this.incomeData.getContactLastName() + ", " + this.incomeData.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {   // телефон +код_страны(код_города)номер_телефона(через тире)
            String countryCode = "" + this.incomeData.getCountryPhoneCode();
            String phoneNumber = String.valueOf(incomeData.getPhoneNumber());
            while (phoneNumber.length() < 10)
            {
                phoneNumber = "0" + phoneNumber;
            }
            return "+" + countryCode + "(" + phoneNumber.substring(0, 3) + ")" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6, 8) + "-" + phoneNumber.substring(8);
        }

        @Override
        public String getCompanyName()
        {
            return this.incomeData.getCompany();
        }

        @Override
        public String getCountryName()
        {
//            String countryName = "";
//            for (Map.Entry<String, String> pair : countries.entrySet()) {
//                if (incomeData.getCountryCode().equals(pair.getKey()))
//                    countryName = pair.getValue();
//            }
//            return countryName;
            return countries.get(this.incomeData.getCountryCode()); // доступ в словарь по ключу, гениально)
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}