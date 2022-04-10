package edu.sda.javaadvanced.java8.functionalInterfaces;

public class Traveller implements Movable{

    private String name;
    private String surName;

    public Traveller(String name, String surName) {
        System.out.println("Tworzymy nowy obiekt z imieniem: " + name + " i nazwiskiem " + surName);
        this.name = name;
        this.surName = surName;
    }


    public String getSurName() {
        return surName;
    }

    //metoda abstrakcyjna w interfejsie - MUSIMY ja nadpisac
    @Override
    public String move() {
        return name + " " + surName + " is traveling";
    }

    //metoda domyslna w interfejsie - NIE MUSIMY nadpisywac
    @Override
    public String moveWith(String partner) {
        return move() + " but this time with " + partner;
    }

    public String travellerInfo() {
        return name + " " + surName;
    }
}
