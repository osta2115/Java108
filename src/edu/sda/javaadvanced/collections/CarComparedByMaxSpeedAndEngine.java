package edu.sda.javaadvanced.collections;

import java.util.Comparator;

public class CarComparedByMaxSpeedAndEngine implements Comparator<Car> {

    @Override
    public int compare(Car car1, Car car2) {
        //Sprawdzamy 1 kryterium - predkosc
        if (car1.getMaxSpeed() != car2.getMaxSpeed()){
            return car1.getMaxSpeed() - car2.getMaxSpeed();
        }

        //Sprawdzamy 2 kryterium jesli wg pierwszego samochody byly rowne
        return car1.getEngine().compareTo(car2.getEngine());
    }
}
