package ru.geekbrains.java3.lesson5;

public abstract class Stage {
    protected int length;
    protected String description;

    public Stage() {
    }

    public String getDescription() {
        return this.description;
    }

    public abstract void go(Car var1);
}
