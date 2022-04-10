package edu.sda.javaadvanced.collections.sets;

import edu.sda.javaadvanced.collections.Car;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        /**
         * Set to interfejs
         * Set - przechowuje zestaw niepowtarzalnych obiektow
         * O niepowtarzalnosci decyduje zestaw hashCode - equals
         * Dostep do dowolnego obiektu w Set jest bardzo szybki
         * Obiekty w Set sa nie poukladane. Dodanie nowego obiektu moze zmienic kolejnosc np. przy wyswietlaniu
         */

        /**
         * HashSet
         * Najbardziej podstawowa, najczesciej wykorzystuwana imprementacja
         */

        Set<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);
        carSet.add(car2);
        carSet.add(car1);
        carSet.add(car4);

        for (Car car : carSet) {
            System.out.println(car.getName() + " " + car.getEngine() + " " + car.hashCode());
        }
        System.out.println();

        /**
         * LinkedHashSet pozwala na utrzymanie kolejnosci elementow wg kolejnosci wstawiania
         */

        Set<Car> setSortedByEntering = new LinkedHashSet<>();
        setSortedByEntering.add(car1);
        setSortedByEntering.add(car2);
        setSortedByEntering.add(car3);
        setSortedByEntering.add(car4);
        for (Car car : setSortedByEntering) {
            System.out.println(car.getName());
        }

        /**
         * TreeSett bedzie ukladal elementu wg zdefiniowanego mechanizmu sortowania
         * Zdefiniowanie mechanizmu sortowania obiektow polega na dodaniu na obiekcie
         * (w naszym przypadku Car) interfejsu Comparable i napisaniu metody compareTo
         */

        Set<Car> treeSet = new TreeSet<>();
        treeSet.add(car1);
        treeSet.add(car2);
        treeSet.add(car3);
        treeSet.add(car4);
        System.out.println("Wyswietlamy treeSet:");
        for (Car car : treeSet) {
            System.out.println(car.getName());
        }

    }
}
