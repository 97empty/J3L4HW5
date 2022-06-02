package ru.geekbrains.java3.lesson5;

import java.io.PrintStream;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + this.length + " метров";
    }

    public void go(Car c) {
        try {
            PrintStream var10000;
            String var10001;
            try {
                var10000 = System.out;
                var10001 = c.getName();
                var10000.println(var10001 + " готовится к этапу(ждет): " + this.description);
                this.smp.acquire();
                var10000 = System.out;
                var10001 = c.getName();
                var10000.println(var10001 + " начал этап: " + this.description);
                Thread.sleep((long)(this.length / c.getSpeed() * 1000));
            } catch (InterruptedException var7) {
                var7.printStackTrace();
            } finally {
                var10000 = System.out;
                var10001 = c.getName();
                var10000.println(var10001 + " закончил этап: " + this.description);
                this.smp.release();
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

    }
}
