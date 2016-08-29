package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args)
    {
        System.out.println(getPartOfString("JavaRush лучший сер вис обучения Java. "));
    }

    public static String getPartOfString(String string) {
        // Проверка входных данных на null
        if (string == null) {
            throw new TooShortStringException();
        }

        // Получаем массив символов из строки
        char[] chars = string.toCharArray();

        // Считаем общее количество пробелов в строке
        int countSpace = 0;
        for (Character character : chars) {
            if (character == 32) countSpace++;
        }

        // Если мало пробелов - кидаем эксепшн
        if (countSpace < 5) throw new TooShortStringException();

        int start = string.indexOf(" ") + 1;        // запоминаем позицию после первого пробела
        int finish = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 32) {                   // находим пробел в массиве
                count++;                            // счетчик++
                if (count == 5) {
                    finish = i;                     // пятый пробел - конец подстроки вывода
                    break;
                }
            }
        }
        return string.substring(start, finish);     // результат - подстрока от символа за первым пробелом до пятого пробела
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
