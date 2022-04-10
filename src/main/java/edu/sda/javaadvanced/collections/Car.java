package edu.sda.javaadvanced.collections;

import java.util.Objects;

/**
 * Klasa jak ta ponizej z konstruktorem ale bez setterow to klasa niemutowalna (immutable)
 * jest bardzo wskazana przy programowaniu w watkach bo z kazdego miejsca odwolanie do
 * obiektu zwroci to samo. Nie ma mozliwosci zmiany pol klasy.
 */

public class Car implements Comparable<Car> {

    private final String name;
    private final String engine;
    private final int maxSpeed;

    public Car(String name, String engine, int maxSpeed) {
        this.name = name;
        this.engine = engine;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }


    /**
     * 1. Metoda toString nie powinna byc wykorzystywana "biznesowo", czyli do wyswietlania danych w aplikacji
     * 2. Jesli potrzebujemy wyswietlic dane to tworzymy dedykowane metody lub wkladamy "w locie"
     */

    public String getCarInfo() {

        /**
         * String vs StringBuilder vs StringBuffer
         * 1. String odklada wszystkie napisy na StringPool i NIE SA ONE USUWANE przez GC (garbage collector)
         * 2. StringBuffer i StringBuilder "skladaja" napis i dopiero jak jest gotowy i zamieniony przez .toString
         *    to wtedy dopiero ten gotowy laduje na StringPool, a wczesniejsze czyszczone
         * 3. StringBuffer dziala od poczatku Javy (1.0) i jest bezpieczny w aplikacjach wielowatkowych ale przez to wolny
         * 4. StringBuilder dziala od Javy (1.5), jest przeznaczony do aplikacji 1-watkowych, ale dzieki temu szybszy
         */

        return new StringBuilder("Car name: ")
                .append(name)
                .append(" , engine: ")
                .append(engine)
                .append(" , maxSpeed: ")
                .append(maxSpeed)
                .toString();
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    /**
     * Kontrakt equals - hashCode
     * Jesli dwa obiekty sa sobie rowne po porownaniu metoda equals to
     * ich hashCode musi byc taki sam
     *
     * Jesli hashCode dwoch obiektow jest taki sam to jeszcze nie znacz ze sa one sobie
     * rowne po porownaniu
     */

    @Override
    public boolean equals(Object o) {
        // 1 krok
        //Sprawdzamy, czy referencje obiektow sa takie same - czy ida do tego samego miejsca w pamieci
        if (this == o) return true;

        //2 krok
        //Sprawdzamy, czy obiekt do porownania nie jest null i czy jest tej samej klasy co obiekt
        //z ktorym go porownujemy (np obiekt klasy Drzewo z obiektem klasy Samochod)
        if (o == null || getClass() != o.getClass()) return false;

        //3 krok
        //Wiemy, ze obiekty sa tej samej klasy, bo inaczej wyszlibysmy z metody krok wczesniej
        //W taki razie wyliczmy iloczyn equals() dla poszczegolnych wskazanych pol
        Car car = (Car) o; //rzutowanie obiektu o na klase Car
        return maxSpeed == car.maxSpeed && Objects.equals(name, car.name) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, engine, maxSpeed);
    }

    /**
     *compareTo zwraca int:
     * - wartosc mniejsza od zera -> "nasz obiekt" (this) jest "przed" obiektem car przekazanym do metody
     * - zero -> obiekty sa rowne
     * - wartosc wieksza od zera -> obiekt orzekazany car jest przed "naszym obiektem this"
     */

    @Override
    public int compareTo(Car car) {

        /**
         * Bedziemy sorotwoac po nazwie samochodu alfabetycznie
         * wiec wystarczy do compareTo dac porownanie nazw
         * Klasa String tez imlementuje compareto wiec wykorzystujemy ten fakt
         */

        return name.compareTo(car.getName());
        //return car.getName().compareTo(name); odwrocone sortowanie
    }
}
