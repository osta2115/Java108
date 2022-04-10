package edu.sda.javaadvanced.collections.exercise;

import java.util.*;

public class HumanDemo {

    public static void main(String[] args) {
        Human human1 = new Human("Dwight", "Schrute", Gennder.MALE, 52);
        Human human2 = new Human("Pam", "Beesly", Gennder.FEMALE, 42);
        Human human3 = new Human("Jim", "Halpert", Gennder.MALE, 43);
        Human human4 = new Human("Michael", "Scott", Gennder.MALE, 56);
        Human human5 = new Human("Angela", "Martin", Gennder.FEMALE, 47);

        List<Human> listofPeople = new ArrayList<>();
        listofPeople.add(human1);
        listofPeople.add(human2);
        listofPeople.add(human3);
        listofPeople.add(human4);
        listofPeople.add(human5);
        listofPeople.add(human4);
        listofPeople.add(human3);

        Set<Human> setOfPeople = new HashSet<>();
        setOfPeople.add(human1);
        setOfPeople.add(human2);
        setOfPeople.add(human3);
        setOfPeople.add(human4);
        setOfPeople.add(human5);
        setOfPeople.add(human4);
        setOfPeople.add(human3);

        System.out.println("Lista ludzi:");
        //printListOfPeople(listofPeople);
        grubaKrecha();

        System.out.println("Set ludzi:");
        printSetOfPeople(setOfPeople);
        grubaKrecha();

        System.out.println("Posortowana lista po nazwisku:");
        listofPeople.sort(Human::compareTo);
        //printListOfPeople(listofPeople);
        grubaKrecha();

        System.out.println("Posortowana lista po nazwisku i imieniu od Z do A:");

        Human human6 = new Human("John", "Scarn", Gennder.MALE, 56);
        Human human7 = new Human("Mose", "Schrute", Gennder.MALE, 47);
        listofPeople.add(human6);
        listofPeople.add(human7);
        Collections.sort(listofPeople, new HumanBySurnameAndNameFromZToAComparator());
        //printListOfPeople(listofPeople);
        grubaKrecha();

        System.out.println("Posortowana po wieku i imieniu:");
        Collections.sort(listofPeople, new HumanByAgeAndNameComparator());
        //printListOfPeople(listofPeople);
        grubaKrecha();

        System.out.println("Posortowana po plci i wieku:");
        Collections.sort(listofPeople, new HumanByGenderAndAgeComparator());
        //listofPeople.sort(new HumanByAgeAndNameComparator()); <--- to samo co wyzej
       //printListOfPeople(listofPeople);
        grubaKrecha();
    }

    private static void printSetOfPeople(Set<Human> setOfPeople) {
        for (Human setOfPerson : setOfPeople) {
            System.out.println(setOfPerson.getHumanInfo());
        }
    }

//    private static void printListOfPeople(List<Human> listofPeople) {
//        for (Human human : listofPeople) {
//            System.out.println(human.getHumanInfo());
//        }
//    }

    private static void grubaKrecha(){
        System.out.println("=====================");
        System.out.println("=====================");
    }
}
