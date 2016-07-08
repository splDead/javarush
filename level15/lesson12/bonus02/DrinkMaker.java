package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by s.goryachev on 01.07.2016.
 */
public abstract class DrinkMaker
{
    abstract void getRightCup(); //выбираем подходящую чашку
    abstract void putIngredient(); //кладем ингредиенты
    abstract void pour(); //заливаем жидкостью
    //готовим напиток
    void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
