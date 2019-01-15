package com.example.andrestapiero.lab3fruitworl2;

class Fruit {

    public  String name;
    public  int poster;



    public Fruit(String name, int poster) {
        this.name= name;
        this.poster = poster;
    }

    public String getName(){return name;}

    public void setName(String name) {
        this.name = name;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
