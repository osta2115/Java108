package edu.sda.javaadvanced.java8.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {

    public static void main(String[] args) {
        class HumanDTO {
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String humanSummary() {
                return  new StringBuilder("DTO: name= ").append(name)
                        .append(" , surname=").append(surname)
                        .toString();
            }
        }

        List<Human> people = new ArrayList<>();
        people.add(new Human("Jan","Kowalski", 22));
        people.add(new Human("Marek","Kowalski", 33));
        people.add(new Human("Pawel","Kowalski", 44));
        people.add(new Human("Marian","Nowak", 15));
        people.add(new Human("Pawel","Wiewior", 55));
        people.add(new Human("Anna","Kowal", 25));

        Set<Human> peopleSet = new HashSet<>();
        peopleSet.add(new Human("Agnieszka", "Zawilska", 25));
        peopleSet.add(new Human("Renata", "Zajac", 33));
        peopleSet.add(new Human("Marta", "Rolecka", 57));
        peopleSet.add(new Human("Zofia", "Papciuch", 44));
        peopleSet.add(new Human("Edyta", "Jachimczak", 38));

        System.out.println("1. Zlaczyc kolekcje i wyswietlic imiona wszystkich ludzi");
        List<Human> humanConcat = Stream.of(people, peopleSet)
                .flatMap(coll -> coll.stream()).toList();

        humanConcat.stream()
                .map(Human::getName)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n2. Wybrac wszystkich, ktorzy nazywaja sie Pawel, Renata albo Agnieszka i wyswietlic");

        humanConcat.stream()
                .filter(human -> human.getName().equals("Pawel") ||
                        human.getName().equals("Renata") || human.getName().equals("Agnieszka"))
                .forEach(Human::printHumanInfo);

        System.out.println("\n3. Wyswietlic ludzi posortowanych po nazwisku od Z do A");

        humanConcat.stream()
                .sorted(new HumanComparedBySurname())
                .forEach(Human::printHumanInfo);

        System.out.println("\n4. Wyswietlic sume wieku ludzi, ale tylko tych starszych niz 35 lat");

        int sumAge = humanConcat.stream()
                .filter(human -> human.getAge() > 35)
                .map(Human::getAge)
                .reduce(0, (currentAge, nextPersonAge) -> currentAge + nextPersonAge);
        System.out.println("Suma lat osob starszych niz 35 lat: " + sumAge);
        System.out.println("\n5. Wyswietlic zlaczone imiona ludzi, miedzy nimi przecinek i spacja, ale tylko ludzi mlodszych niz 40 lat");

        String namesConcat = humanConcat.stream()
                .filter(human -> human.getAge() < 40)
                .map(Human::getName)
                .collect(Collectors.joining(", "));
        System.out.println(namesConcat);
    }
}
