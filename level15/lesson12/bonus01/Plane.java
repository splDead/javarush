package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by s.goryachev on 01.07.2016.
 */
public class Plane implements Flyable
{
    int mansInPlane; //количество пассажиров в самолете

    @Override
    public void fly()
    {

    }

    public Plane(int i) {
        this.mansInPlane = i;
    }
}
