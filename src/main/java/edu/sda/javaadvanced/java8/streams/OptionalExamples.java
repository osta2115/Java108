package edu.sda.javaadvanced.java8.streams;

import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalExamples {
    public static void main(String[] args) {
        /**
         * Java8 wprowadzila Optional, czyli "opakwoanie" na obiekt, gdzie w srodku moze byc obiekt, a moze go nei byc
         */

        Human human = new Human("Jan", "Kowalski", 33);
        Human nullHuman = null;

        System.out.println(human.getAge());
        //System.out.println(nullHuman.getAge()); - nullHuman jest null stad wywolanie na nim getAge konczy sie NPE

        //metoda of tworzy optionala na nie nullowym obiekcie
        Optional<Human> optionalHuman = Optional.of(human);

        //metoda ofNullable tworzy optionala na byc moze nullowym obiekcie
        Optional<Human> nullOptionalHuman = Optional.ofNullable(nullHuman);

        //stworzenie optionala z okiektu nullowego metoda of konczy sie wyjatkiem
        //Optional<Human> anotherNullable = Optional.of(nullHuman);

        //Od javy 8 - sprawdzenie zawartosci metoda isEmpty
        if (nullOptionalHuman.isEmpty()){
            System.out.println("Null w optionalu");
        }

        //od javy 11 - kolejna metdoa sprawdzania zawartosci - pojawila sie bo najczesciej programisci robili !isEmpty
        if (nullOptionalHuman.isPresent()) {
            System.out.println("Nie ma nulla w optionalu");
        }

        //pobranie zawartosci Optionala
        //sugerowane jest aby najpierw spradzic czy jest co pobrac aby nie skonczylo sie na czerwono
        //Human stupid = nullOptionalHuman.get(); w srodku null wiec dostaniemy exception
        Human finalHuman = optionalHuman.get();

        LinkedList<Human> humanLinkedList = new LinkedList<>();
        humanLinkedList.add(human);
        humanLinkedList.add(human);
        humanLinkedList.add(human);
        humanLinkedList.add(human);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Wyswietlamy imie albo 'Nikt' jesli rozne od zadanego warunku");
        String found = humanLinkedList.stream()
                .map(Human::getName)
                .filter(each -> "Jan".equalsIgnoreCase(each))
                .findFirst()
                .orElse("Nikt");
        System.out.println("Co znaleziono: " + found);
        Optional<String> eventuallyFound = humanLinkedList.stream()
                .map(Human::getName)
                .filter(each -> each.equalsIgnoreCase("Jas"))
                .findAny();

        if (eventuallyFound.isPresent()){
            System.out.println("Znaleziono " + eventuallyFound);
        } else {
            System.out.println("Nic nie znaleziono bo Jas to nie Jan");
        }
        System.out.println("Szukamy Jana i chcemy go pobrac do nowej zmiennej");
        Human jan = humanLinkedList.stream()
                .filter(each -> "Jan".equalsIgnoreCase(each.getName()))
                .findFirst()
                .orElse(new Human("John", "Doe", 22));
        System.out.println(jan.getHumanInfo());
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Zeby nie tworzyc dodatkowego obiektu korzystamy z  orElseGet zamiast orElse");
        Human janDzban = humanLinkedList.stream()
                .filter(each -> "Jan".equalsIgnoreCase(each.getName()))
                .findFirst()
                .orElseGet(() -> new Human("John", "Doe", 22));
        System.out.println("orElseGet przyjmuje Suppliera, wiec wykona sie tylko w przypadku wywolania");
        System.out.println(janDzban.getHumanInfo());
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("A teraz Jasia szukamy");
        Human jasio = humanLinkedList.stream()
                .filter(each -> "Jas".equalsIgnoreCase(each.getName()))
                .findFirst()
                .orElseGet(() -> new Human("John", "Doe", 22));
        jasio.printHumanInfo();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("Jesli po filtrowaniu nie ma elementow do zwrotu to");

    }
}
