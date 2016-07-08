package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.*;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public static void main (String[] args) {
        ArrayList<Beach> beachlist = new ArrayList<Beach>(); //создаем список пляжей
        Random rand = new Random();
        //создаем и присваиваем пляжам рандомные характеристики
        for (int i = 1; i < 5; i++)
        {
            beachlist.add(new Beach("Beach#"+i, rand.nextFloat()*1000, rand.nextInt(10) ));
        }
        //сортируем список используя переопределенный метод
        Collections.sort(beachlist);
        //вывод на консоль отсортированного списка
        for (Beach b : beachlist)
            System.out.println(b.getName() + " " + b.getQuality() + " " + b.getDistance());
    }

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o)
    {
        return name.compareTo(o.getName()) + (int)(distance*quality - o.getDistance()*o.getQuality());
    }
}
