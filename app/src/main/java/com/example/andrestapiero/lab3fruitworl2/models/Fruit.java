package com.example.andrestapiero.lab3fruitworl2.models;

public class Fruit {

    public String name;
    private String description;
    public int poster;
    public int count;


    //valores condiciones
    public static final int LIMIT_QUANTITY = 10;
    public static final int RESET_VALUE_QUANTITY = 0;


    public Fruit(String name, int icon, String description, int count) {
        this.name = name;
        this.poster = icon;
        this.description = description;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void addQuantity(int count) {
       if(this.count < LIMIT_QUANTITY) {
           this.count += count;
       }
    }

    public void resetQuantity() {
        this.count = RESET_VALUE_QUANTITY;
    }
}
