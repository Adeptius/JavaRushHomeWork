package com.javarush.test.level32.lesson06.task01;

import java.io.ByteArrayOutputStream;

/* Генератор паролей
Реализуйте логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов
2) только цифры и латинские буквы разного регистра
3) обязательно должны присутствовать цифры, и буквы разного регистра
Все сгенерированные пароли должны быть уникальные.
Пример правильного пароля:
wMh7SmNu
*/
public class Solution {
    public static void main(String[] args)  throws Exception {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() throws Exception{
        ByteArrayOutputStream pass = new ByteArrayOutputStream();
        boolean lowerIsPresent = false;
        boolean upperIsPresent = false;
        boolean numbersIsPresent = false;
        for (int i = 0; i < 8; i++) {
            long sw = Math.round(Math.random()*2);
            if (sw==0){
                pass.write((char) Math.round(Math.random()*9) + 48);
                numbersIsPresent = true;
            }
            if (sw==1){
                pass.write((char) Math.round(Math.random()*25) + 65);
                upperIsPresent = true;
            }
            if(sw==2){
                pass.write((char) Math.round(Math.random()*25) + 97);
                lowerIsPresent = true;
            }
        }

        if (lowerIsPresent && upperIsPresent && numbersIsPresent) return pass;
        else return getPassword();
    }
}
