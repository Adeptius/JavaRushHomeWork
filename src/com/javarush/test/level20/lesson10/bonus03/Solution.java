package com.javarush.test.level20.lesson10.bonus03;

import java.util.ArrayList;
import java.util.List;

/* Кроссворд
1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
text - это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
             //   0   1   2   3   4   5
                {'f','d','e','r','l','k'},//0
                {'u','s','a','m','e','o'},//1
                {'l','n','g','r','o','v'},//2
                {'m','l','p','r','r','h'},//3
                {'s','a','m','e','j','j'} //4
        };
        List<Word> listWord2 = detectAllWords(crossword, "home", "same", "unp");

        for (Word w : listWord2) System.out.println(w);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        cross = crossword;
        List<Word> listWord = new ArrayList<>();
        for (String s : words) {
            startY = 0;
            startX = 0;
            String currentWord = s;
            searchCountOfStartWords(currentWord.charAt(0));

            for (int i = 0; i < foundStartWords; i++) {
                findNextWordPos(currentWord.charAt(0));
                searchWord(currentWord);
                if (wordIsFound) {
                    Word wor = new Word(currentWord);
                    wor.setStartPoint(startX, startY);
                    wor.setEndPoint(endX, endY);
                    listWord.add(wor);
                }
            }
            foundStartWords = 0;
        }
        return listWord;
    }

    public static int[][] cross;
    public static int startY = 0;
    public static int startX = 0;
    public static int endY = 0;
    public static int endX = 0;
    public static int foundStartWords = 0;
    public static boolean wordIsFound = false;

    public static void searchCountOfStartWords(char c){
        // Ищем сколько всего точек начала.
        for (int i = 0; i < cross.length; i++) {
            for (int j = 0; j <cross[i].length ; j++) {
                if ((char)cross[i][j] == c){
                    foundStartWords++;
                }
            }
        }
        startY = 0;
        startX = 0;
    }

    public static void findNextWordPos(char c){
        // задаём следующую позицию для старта
        boolean continu = true;
        for (int i = startY; i < cross.length; i++) {
            for (int j = continu ? startX+1 : 0; j <cross[i].length ; j++) {
                if ((char)cross[i][j] == c){
                    startY = i;
                    startX = j;
                    return;
                }
            }
            continu = false;
        }
    }

    public static void searchWord(String s){
        char[] word = s.toCharArray();
        int wordsCount = word.length;
        int x,y;
        wordIsFound = false;

        for (int i = 0; i < 1; i++) {

            // ищем вправо
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y][x++] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x - 1;
                            endY = y;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}


            // ищем влево
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y][x--] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x + 1;
                            endY = y;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}

            // ищем вверх
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y--][x] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x;
                            endY = y+1;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}

            // ищем вниз
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y++][x] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x;
                            endY = y-1;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}

            // ищем вверх - вправо
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y--][x++] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x-1;
                            endY = y+1;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}

            // ищем вверх - влево
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y--][x--] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x+1;
                            endY = y+1;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}


            // ищем вниз - вправо
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y++][x++] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x-1;
                            endY = y-1;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}



            // ищем вниз - влево
            try {
                if (wordIsFound) break;
                y = startY;
                x = startX;
                for (int j = 0; j < wordsCount; j++) {
                    if (!(cross[y++][x--] == word[j])) break;
                    else {
                        if (j == wordsCount - 1) {
                            wordIsFound = true;
                            endX = x+1;
                            endY = y-1;
                        }
                        continue;
                    }
                }
            }catch (ArrayIndexOutOfBoundsException e){}
        }
    }



    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
