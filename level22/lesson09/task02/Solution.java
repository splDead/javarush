package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    /**
     * Задание следует понимать буквально, попытки сделать красиво с доп проверками - провалились
     * Учитывать только одно условие, значение не должно быть null
     * @param params
     * @return
     */
    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()) {
            if (pair.getValue() != null) {
                if (result.toString().equals(""))
                    result.append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
                else
                    result.append(" and ").append(pair.getKey()).append(" = '").append(pair.getValue()).append("'");
            }
        }
        return result;
    }
}
