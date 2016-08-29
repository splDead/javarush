package com.javarush.test.level22.lesson05.task02;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException
    {
        // Проверка входных данных на null
        if (string == null) {
            throw new TooShortStringException();
        }

        // Получаем массив символов из строки
        char[] chars = string.toCharArray();

        // Считаем общее количество табов в строке
        int countTabs = 0;
        for (Character character : chars) {
            if (character == 9) countTabs++;
        }

        // Если мало табов - кидаем эксепшн
        if (countTabs < 2) throw new TooShortStringException();

        int start = string.indexOf("\t") + 1;       // запоминаем позицию после первого таба
        int finish = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 9) {                    // находим таб в массиве
                count++;                            // счетчик++
                if (count == 2) {
                    finish = i;                     // второй таб - конец подстроки вывода
                    break;
                }
            }
        }
        if (string.substring(start, finish).isEmpty())
            return "";
        else
            return string.substring(start, finish);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
