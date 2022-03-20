package edu.sda.javaadvanced.collections.lists;

import edu.sda.javaadvanced.collections.Car;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

    /**
     * Definicja kolekcji przed Java 1.7:
     */
    List<Car> oldStyleList = new ArrayList<Car>();

    /**
     * Definicja teraz:
     */

    List<Car> carList = new ArrayList<>();

    /**
     * List jest interfeacem
     * Zawiera ogolna definicje listy. Charakteryzuje sie tym, ze:
     *  - elementy sa ulozone po kolei,
     *  - mozemy dostac sie dowolnego elementu poslugujac sie indeksem,
     *  - moze zawierac duplikaty, czyli wielokrotnie ten sam obiekt,
     *  -
     */

    /**
     * ArrayList jest najprostsza i najczesciej stosowana implementacja listy
     * Ma domyslny rozmiar poczatkowy, podobnie do tablicy
     * Po dodaniu okreslonej liczby elementow, jest automatycznie powiekszana
     * Jest ulozona w kolejnych komorkach pamieci, podobnie jak tablica
     * Bardzo szybko mozna wybrac dowolny element z tablicy
     * Usuwanie elementow z tablicy jest dlugotrwale
     * [x][x][x][x]
     */

    /**
     * LinkedList jest lista utworzona na zasadzie wezlow "poprzednik - nastepnik"
     * Nie jest przechowywana w pojedynczym miejscu w pamieci
     * Dodanie dowolnego elementu w dowolne miejsce jest szybkie
     * Usuniecie elementu z dowolnego miejsca jest szybkie
     * Im wieksza lista tym dluzszy czas potrzebny na wyszukanie konretnego elementu po indeksie
     * [x]-[x][x]-------[x][x]--[x]---[x]--[x]--[x][x]
     */
    carList.add(car1);
    carList.add(car2);
    carList.add(car1);
    carList.add(car3);
    carList.add(car4);
    carList.add(car1);

        System.out.println("Drukujemy zawartosc arrayListy, sprawdzamy czy sa duplikaty");
        for (Car car : carList) {
            System.out.println(car);
        }

        carList.remove(car1); //usuniemy pierwsze wystapienie car1
        System.out.println("========================================================");

        System.out.println("Drukujemy zawartosc arrayListy, sprawdzamy czy usunelo pierwszy car1");
        for (Car car : carList) {
            System.out.println(car);
        }

        carList.remove(3);
        System.out.println("========================================================");

        System.out.println("Drukujemy zawartosc arrayListy, sprawdzamy czy usunelo fiata");
        for (Car car : carList) {
            System.out.println(car);
        }

        carList.add(1,car4);
        System.out.println("========================================================");

        System.out.println("Drukujemy zawartosc arrayListy, dodajemy spowrotem fiata lae wczesniej -> na druga pozycje");
        for (Car car : carList) {
            System.out.println(car);
        }

        List<Car> carsToRemove = new ArrayList<>();
        carsToRemove.add(car4);
        carsToRemove.add(car3);
        carList.add(car4);
        carList.add(car4);
        carList.add(car4);
        carList.removeAll(carsToRemove);
        System.out.println("========================================================");

        System.out.println("Drukujemy zawartosc arrayListy, drukujemy po usunieciu grupy");
        for (Car car : carList) {
            System.out.println(car);
        }

        if (carList.contains(car2)) {
            System.out.println("Lista zawiera car2");
        }

        System.out.println("Drukujemy hashCode obiektow z listy");
        carList.add(car1);
        carList.add(car3);
        carList.add(car4);
        for (Car car : carList) {
            System.out.println(car.getName() + " " + car.hashCode());
        }

    }
}
