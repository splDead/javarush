package com.javarush.test.level15.lesson12.home05;

/**
 * Created by s.goryachev on 20 Oct 2015.
 */
public class SubSolution extends Solution
{
    SubSolution(Integer integer)
    {
        super(integer);
    }

    SubSolution(String s)
    {
        super(s);
    }

    SubSolution(Double d)
    {
        super(d);
    }

    protected SubSolution(Byte b)
    {
        super(b);
    }

    protected SubSolution(Short ss)
    {
        super(ss);
    }

    protected SubSolution(Float f)
    {
        super(f);
    }

    public SubSolution(int i)
    {
        super(i);
    }

    public SubSolution(long l)
    {
        super(l);
    }

    public SubSolution(double d)
    {
        super(d);
    }

    private SubSolution(byte b) {super(b);}
    private SubSolution(short s) {super(s);}
    private SubSolution(float f) {super(f);}
}
