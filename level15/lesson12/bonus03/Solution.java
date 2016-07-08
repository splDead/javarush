package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 1 до введенного числа включая его.
Пример: 4! = factorial(4) = 1*2*3*4 = 24
1. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 1
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        if (input > 150) //проверяем число согласно условия №1, меньше или равно 150
        {
            System.out.print("Вы ввели число больше 150, не надо так: ");
            input = Integer.parseInt(reader.readLine());
        }
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here
        if (n < 0) return "0"; //для отрицательных чисел вывод 0
        if (n == 0) return "1"; //для нуля вывод 1
        BigInteger result = BigInteger.valueOf(1); //считаем большое число
        BigInteger num1 = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++) {
            BigInteger num2 = BigInteger.valueOf(i);
            result = num1.multiply(num2);
            num1 = result;
        }
        return result.toString();
    }
}
