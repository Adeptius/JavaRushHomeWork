package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    Solution(Long a){}
    Solution(byte a){}
    Solution(Integer a){}
    public Solution(Object a){}
    public Solution(Float a){}
    public Solution(Double a){}
    protected Solution(String a){}
    protected Solution(long a){}
    protected Solution(short a){}
    private Solution(double a){}
    private Solution(int a){}
    private Solution(char a){}
}

