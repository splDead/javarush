package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by s.goryachev on 23.08.2016.
 */
public class Hippodrome
{
    private static ArrayList<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();

        Horse twilightSparkle = new Horse("Twilight Sparkle", 3.0, 0.0);
        Horse appleJack = new Horse("Applejack", 3.0, 0.0);
        Horse rainbowDash = new Horse("Rainbow Dash", 3.0, 0.0);

        horses.add(twilightSparkle);
        horses.add(appleJack);
        horses.add(rainbowDash);

        game.run();
        game.printWinner();
    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException
    {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(500);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        double win = horses.get(0).getDistance();
        int count = 0;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getDistance() > win) {
                win = horses.get(i).getDistance();
                count = i;
            }
        }
        return horses.get(count);
    }

    public void printWinner() {
        System.out.printf("Winner is %s!\n", getWinner().getName());
    }
}
