package ru.geekbrains.java3.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT = 0;
    private static boolean winnerFound;
    private static final Lock win = new ReentrantLock();
    private final Race race;
    private final int speed;
    private final String name;
    private int count;
    private final CyclicBarrier cb;

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getCount() {
        return this.count;
    }

    public Car(Race race, int speed, CyclicBarrier cb, CountDownLatch cdl) {
        this.race = race;
        this.speed = speed;
        ++CARS_COUNT;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
    }

    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep((long)(500 + (int)(Math.random() * 800.0D)));
            System.out.println(this.name + " готов");
            this.cb.await();
            this.cb.await();

            for(int i = 0; i < this.race.getStages().size(); ++i) {
                ((Stage)this.race.getStages().get(i)).go(this);
            }

            checkWinner(this);
            this.cb.await();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private static synchronized void checkWinner(Car c) {
        if (!winnerFound) {
            System.out.println(c.name + " - WIN");
            winnerFound = true;
        }

    }
}