package ru.geekbrains.java3.lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final int HALF_CARS_COUNT = 2;

    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        CyclicBarrier cb = new CyclicBarrier(5);
        CountDownLatch cdl = new CountDownLatch(4);
        Race race = new Race(new Stage[]{new Road(60), new Tunnel(), new Road(40)});
        Car[] cars = new Car[4];

        for(int i = 0; i < cars.length; ++i) {
            cars[i] = new Car(race, 20 + (int)(Math.random() * 10.0D), cb, cdl);
        }

        Car[] var10 = cars;
        int var6 = cars.length;

        for(int var7 = 0; var7 < var6; ++var7) {
            Car car = var10[var7];
            (new Thread(car)).start();
        }

        try {
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
            cb.await();
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
