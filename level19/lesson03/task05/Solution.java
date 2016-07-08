package com.javarush.test.level19.lesson03.task05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Закрепляем адаптер
Адаптировать Customer и Contact к RowItem.
Классом-адаптером является DataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
*/

public class Solution {
    private static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main (String[] args) {

        DataAdapter dataAdapter = new DataAdapter(new Customer()
        {
            @Override
            public String getCountryName()
            {
                return "Ukraine";
            }

            @Override
            public String getCompanyName() { return "JavaRush Ltd."; }
        }, new Contact()
        {
            @Override
            public String getName()
            {
                return "Ivanov, Ivan";
            }

            @Override
            public String getPhoneNumber() { return "+38(050)123-45-67"; }
        });

        System.out.println(dataAdapter.getCountryCode());
        System.out.println(dataAdapter.getCompany());
        System.out.println(dataAdapter.getContactFirstName());
        System.out.println(dataAdapter.getContactLastName());
        System.out.println(dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {

        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode()
        {
            String countryName = "";
            for (Map.Entry<String, String> pair : countries.entrySet()) {
                if (customer.getCountryName().equals(pair.getValue()))
                    countryName = pair.getKey();
            }
            return countryName;
        }

        @Override
        public String getCompany()
        {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName()
        {
            String firstName = contact.getName();
            return firstName.substring(firstName.lastIndexOf(" ") + 1);
        }

        @Override
        public String getContactLastName()
        {
            String lastName = contact.getName();
            return lastName.substring(0, lastName.lastIndexOf(","));
        }

        @Override
        public String getDialString()
        {
            String phoneNumber = contact.getPhoneNumber();
            String countryCode = phoneNumber.substring(0, phoneNumber.lastIndexOf("("));
            String cityCode = phoneNumber.substring(phoneNumber.lastIndexOf("(") + 1, phoneNumber.lastIndexOf(")"));
            String[] number = phoneNumber.substring(phoneNumber.lastIndexOf(")") + 1).split("-");
            String num = "";
            for (String s : number) num += s;
            return "callto://" + countryCode + cityCode + num;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
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