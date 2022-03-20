package edu.sda.javaadvanced.collections.maps;

import edu.sda.javaadvanced.collections.Car;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        /**
         * Mapa - struktura przechowujaca dane w formacie Klucz-Wartosc
         *
         * Map<K,V> - zaklada, ze klucze musza byc unikalne, a wartosci juz nie koniecznie
         * Klucze sa niepowtarzalne, ale dla roznych kluczy moga wystapic te same wartosci
         *
         * Map to interfejs, konkretne implementacje to HashMap, LinkedHashMap, TreeMap - nazwy odnosza sie do faktu,
         * ze klucze przechowywane sa jako SET
         */

        Map<String, Car> carMap = new HashMap<>();
        carMap.put(car1.getName(),car1);
        carMap.put(car2.getName(),car2);
        carMap.put(car3.getName(),car3);
        carMap.put(car4.getName(),car4);
        System.out.println("Wyswietlamy wartsci mapy - czyli samochody, uzyjemy getCarInfo");
        System.out.println("Iterowanie po kluczach");
        for (String carName : carMap.keySet()) {
            System.out.println("Nazwa samochodu: " + carName);
            System.out.println("Info o samochodzie: " + carMap.get(carName).getCarInfo()); // get pobiera wartosc spod wskazanego klucza
        }
        grubaKrecha();

        System.out.println("Iterowanie po wartosciach");
        for (Car car : carMap.values()) {
            System.out.println("Kolejny raz info: " + car.getCarInfo());
        }
        grubaKrecha();

        System.out.println("Iterowanie po wpisach");
        //Wpis to zestaw <klucz, wartosc>
        for (Map.Entry<String, Car> entry : carMap.entrySet()) {
            System.out.println("Klucz: " + entry.getKey());
            System.out.println("Wartosc: " + entry.getValue().getCarInfo());
        }


        //Podamiana elementu pod wskazanym kluczem
        carMap.put(car1.getName(), car2);
        System.out.println("Iterowanie po kluczach po wprowadzeniu duplikatu: ");
        for (String carName : carMap.keySet()) {
            System.out.println("Nazwa samochodu: " + carName);
            System.out.println("Info o samochodzie: " + carMap.get(carName).getCarInfo()); // get pobiera wartosc spod wskazanego klucza
        }
        grubaKrecha();

        System.out.println("Czy mapa pusta? " + carMap.isEmpty());
        System.out.println("Rozmiar mapy? " + carMap.size());
        grubaKrecha();

        carMap.remove(car3.getName());
        System.out.println("Iterowanie po kluczach po usunieciu elementu: ");
        for (String carName : carMap.keySet()) {
            System.out.println("Nazwa samochodu: " + carName);
            System.out.println("Info o samochodzie: " + carMap.get(carName).getCarInfo()); // get pobiera wartosc spod wskazanego klucza
        }
        grubaKrecha();
}

    private static void grubaKrecha(){
        System.out.println("=====================");
        System.out.println("=====================");
    }


}
