package com.example.vraun.habbittracking;

/**
 * Created by vraun on 28-02-2017.
 */

public class Details {
    int habitID;
    String habitTitle;
    int habitFrequency;

    public Details() {

    }

    public Details(String habitTitle, int habitFrequency) {
        this.habitTitle = habitTitle;
        this.habitFrequency = habitFrequency;
    }
    //Getters

    public int getHabitID() {
        return habitID;
    }

    //Setters
    public void setHabitID(int id) {
        this.habitID = id;
    }

    public String getHabitTitle() {
        return this.habitTitle;
    }

    public void setHabitTitle(String name) {
        this.habitTitle = name;
    }

    public int getHabitFrequency() {
        return this.habitFrequency;
    }

    public void setHabitFrequency(int i) {
        this.habitFrequency = i;
    }
}
