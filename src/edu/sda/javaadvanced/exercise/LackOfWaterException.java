package edu.sda.javaadvanced.exercise;

public class LackOfWaterException extends IllegalArgumentException {

    public LackOfWaterException(String s) {
        super(s);
        System.out.println("Brak wody!!! bo pozycja: " + s);
    }
}
