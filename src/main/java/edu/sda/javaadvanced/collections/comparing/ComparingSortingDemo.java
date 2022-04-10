package edu.sda.javaadvanced.collections.comparing;

import edu.sda.javaadvanced.collections.Car;
import edu.sda.javaadvanced.collections.CarComparedByEngine;
import edu.sda.javaadvanced.collections.CarComparedByMaxSpeedAndEngine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ComparingSortingDemo {

    public static void main(String[] args) {

        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        List<Car> listCar = new ArrayList<>();
        listCar.add(car1);
        listCar.add(car2);
        listCar.add(car3);
        listCar.add(car4);

        grubaKrecha();
        printList(listCar);
        grubaKrecha();
        System.out.println("A teraz posortujemy dane po nazwie samochodu");

        /**
         * Metoda Collections.sort wykorzystuje komparator metody czyli wymaga zeby na klasie byl Comparable
         * i zaimplementowana metoda compareTo
         */

        Collections.sort(listCar);
        printList(listCar);

        grubaKrecha();

        /**
         * Mozemy wykorzystac tez zewnetrzny komparator
         */

        Collections.sort(listCar, new CarComparedByEngine());
        printList(listCar);

        grubaKrecha();

        /**
         * Podwojny komparator - sortowanie po maxspeed, a nastepnie po silniku
         */

        Car car5 = new Car("Seat", "1.7", 220);
        listCar.add(car5);
        Collections.sort(listCar, new CarComparedByMaxSpeedAndEngine());
        printList(listCar);
    }

    private static void printList(List<Car> listCar) {
        for (Car car : listCar) {
            System.out.println(car.getCarInfo());
        }
    }

    private static void grubaKrecha(){
        System.out.println("=====================");
        System.out.println("=====================");
    }
}
