package edu.sda.javaadvanced.java8.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;

public class TestFunctionalInterfaces {

    public static void main(String[] args) {

        /**
         * Zdefiniowanie:
         * Movable human = new Traveller to tzw polimorfizm, czyli:
         * kazdy Traveller jest Movable, ale nie kazdy Movable to Traveller
         */

        Movable human = new Traveller("Jan", "Kowalski");
        Movable bird = new Bird("Bocian polak");

        System.out.println("=============================");
        System.out.println(human.move());
        System.out.println(bird.move());
        System.out.println("=============================");
        System.out.println(human.moveWith("Marcin Nowak"));
        System.out.println(bird.moveWith("wrubel"));
        System.out.println("=============================");

        /**
         * Po co jest polimorfizm:
         * bo mozemy dzieki temu wrzucic rozne de fakto obiekty do jednego "worka" i potraktowac je tak samo
         */

        List<Movable> allInMove = new ArrayList<>();
        allInMove.add(human);
        allInMove.add(bird);
        for (Movable movable : allInMove) {
            System.out.println(movable.move());
        }
        System.out.println("==================");
        System.out.println("==================");
        System.out.println("Polimorfizm");
        Movable anotherHuman = new Traveller("Margola", "Kiepska");
        allInMove.add(anotherHuman);
        Traveller yetAnotherInMove = new Traveller("Adam", "Malysz");
        allInMove.add(yetAnotherInMove);

        //zeby wywolac metode travellerInfo robimy rzutowanie
        System.out.println(((Traveller) anotherHuman).travellerInfo());


        System.out.println("==================");
        System.out.println("==================");
        System.out.println("==================");
        List<Traveller> travellers = new ArrayList<>();

        /**
         * poniżej mówimy "drogi kompilatorze, wiem że human jest powołany do życia jako Movable
         * ale uwierz mi na słowo, to jest Traveller i tak go potraktuj"
         * kompilator próbuje uwierzyć i "transformuje" Movable Human do Travellera i to działa
         */

        travellers.add((Traveller) human);

        /**
         * Tu też kompilator wierzy nam na słowo ale Eagle nie jest Travellerem, stąd przy próbie
         * podmiany kompilator wywala błąd że go oszukaliśmy
         */

        travellers.add((Traveller) bird);
    }
}
