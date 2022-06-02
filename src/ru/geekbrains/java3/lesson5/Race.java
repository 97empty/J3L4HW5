package ru.geekbrains.java3.lesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private final ArrayList<Stage> stages;

    public ArrayList<Stage> getStages() {
        return this.stages;
    }

    public Race(Stage... stages) {
        this.stages = new ArrayList(Arrays.asList(stages));
    }
}
