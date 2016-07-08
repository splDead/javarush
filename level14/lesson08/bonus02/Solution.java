package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        if (num1 <= 0) { //проверка положительности первого числа
            System.out.print("Вы ввели ноль или отрицательное число, введите снова: ");
            num1 = Integer.parseInt(br.readLine());
        }
        int num2 = Integer.parseInt(br.readLine());
        if (num2 <= 0) { //проверка положительности второго числа
            System.out.print("Вы ввели ноль или отрицательное число, введите снова: ");
            num2 = Integer.parseInt(br.readLine());
        }
        int min = 0;
        //узнаем минимум, он может оказаться НОДом
        if (num1 > num2) {
            min = num2;
        }
        else
            min = num1;
        int nod = 1;
        for (int i = min; i > 1; i--) {
            //проверяем минимум, НОД ли он, дальше в сторону уменьшения
            if (num1%i == 0 && num2%i == 0)
            {
                nod = i;
                break;
            }
        }
        System.out.println(nod);
    }
}
