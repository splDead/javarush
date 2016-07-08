package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int i = 0;


        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                i += sc.nextInt();
            }
            else {
                String s = sc.next();
                if (s.equals("сумма"))
                    break;
            }
        }
        System.out.println(i);
    }
}
