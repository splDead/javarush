package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import java.util.Objects;

public class Solution {

    Solution(Integer integer) {}
    Solution(String s) {}
    Solution(Double d) {}

    protected Solution(Byte b){}
    protected Solution(Short ss){}
    protected Solution(Float f){}

    public Solution(int i){}
    public Solution(long l){}
    public Solution(double d){}

    private Solution(byte b) {}
    private Solution(short s) {}
    private Solution(float f) {}

}

