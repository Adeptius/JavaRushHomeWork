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

    public static StringBuilder getCondition(Map<String, String> params)
    {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> stringEntry : params.entrySet())
        {
            if (stringEntry.getValue() != null)
            {
                if (sb.toString().equals(""))
                    sb.append(stringEntry.getKey()).append(" = '").append(stringEntry.getValue()).append("'");
                else
                    sb.append(" and ").append(stringEntry.getKey()).append(" = '").append(stringEntry.getValue()).append("'");
            }
        }
        return sb;
    }
}
