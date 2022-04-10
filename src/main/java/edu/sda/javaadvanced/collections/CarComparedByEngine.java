package edu.sda.javaadvanced.collections;

import java.util.Comparator;

/**
 * Klasa odpowiedzialna za sortowanie samochodow po wielkosci silnika
 *
 * Zalozenia:
 * 1. Domyslnie samochody sortujemy po marce - do tego sluzy Comparable<Car> na klasie Car
 * 2. Moga pojawic sie potrzeby sortowania innego niz domyslne - de tego dokladamy wlasnie osobne
 *    klasy - dla kazdego takiegoalgorytmu osobno
 * 3. Do dodatkowego sortowania uzywamy interfejsu Comparator<Car>
 */

public class CarComparedByEngine implements Comparator<Car> {

    /**
     * Comparato wymusza nadpisanie metody compare
     * Ma tez inne metody, ale sa one domyslne i nie ma potrzeby ich nadpisywania - czyli mozna ale nie trzeba
     */

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getEngine().compareTo(car2.getEngine());
    }
}
