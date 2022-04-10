package edu.sda.javaadvanced.java8.functionalInterfaces.supplier;

import edu.sda.javaadvanced.java8.functionalInterfaces.Traveller;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {
        Traveller traveller1 = new Traveller("Jan", "Kowalski");
        Traveller traveller2 = new Traveller("Alina", "Nowak");

        /**
         * Supplier jest interfejsem funkcyjnym, ktory nie przyjmuje zadnego parametru, a zwraca obiekt
         * Korzystanie z suppliera oznacza, ze definujemy jego metode get
         */

        Supplier<Traveller> childTraveller = () -> new Traveller("Julcia", "Kupcia");
        Supplier<Traveller> elder = () -> new Traveller("Marek", "Papszun");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(traveller1.travellerInfo());
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(childTraveller.get().travellerInfo());
        System.out.println("++++++++++++++++++++++++++");
        Traveller trainer = elder.get();
        System.out.println(trainer.travellerInfo());
        System.out.println("++++++++++++++++++++++++++");

        /**
         * Z interfejsow bardzo fajnie korzysta sie w polaczeniu z metodami
         */
        System.out.println(travellerExtendedInfo(childTraveller));
        System.out.println("*********************");
        System.out.println(travellerExtendedInfo(elder));
        System.out.println("*********************");
        System.out.println("!!! Z instniejacego obiektu terz mozemy zrobic suppliera !!!");
        System.out.println(travellerExtendedInfo(() -> traveller1));
    }

    public static String travellerExtendedInfo(Supplier<Traveller> travellerToUse) {
        Traveller traveller = travellerToUse.get();
        return new StringBuilder("============ \n")
                .append(traveller.travellerInfo())
                .append("\n==================")
                .toString();
    }



}
