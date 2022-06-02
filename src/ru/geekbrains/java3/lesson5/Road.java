package ru.geekbrains.java3.lesson5;

import java.io.PrintStream;

public class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    public void go(Car c) {
        try {
            PrintStream var10000 = System.out;
            String var10001 = c.getName();
            var10000.println(var10001 + " начал этап: " + this.description);
            Thread.sleep((long)(this.length / c.getSpeed() * 1000));
            var10000 = System.out;
            var10001 = c.getName();
            var10000.println(var10001 + " закончил этап: " + this.description);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

    }
}
