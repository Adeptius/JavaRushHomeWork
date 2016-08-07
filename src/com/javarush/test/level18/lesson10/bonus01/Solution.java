package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(args[1]);
        byte[] inputFile = new byte[fis.available()];
        fis.read(inputFile);
        fis.close();


        FileOutputStream fos = new FileOutputStream(args[2]);
        if (args[0].equals("-e")){
            inputFile = encrypt(inputFile);
            fos.write(inputFile);
            fos.close();
        }
        if (args[0].equals("-d")){
            inputFile = encrypt(inputFile);
            fos.write(inputFile);
            fos.close();
        }

    }

    private static byte[] encrypt(byte[] toEncrypt){
        byte temp;
        int i = 0;
        while (i < toEncrypt.length-2) {
            temp = toEncrypt[i];
            toEncrypt[i] = toEncrypt[i+1];
            toEncrypt[i+1] = temp;
            i += 2;
        }
        return toEncrypt;

    }

    private static byte[] decrypt(byte[] toDecrypt){
        return encrypt(toDecrypt);
    }

}
