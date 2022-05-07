package edu.sda.javaadvanced.java8.lambdas;

public class Samples {
    public static void main(String[] args) {

        /**
         *Lambda to skrocony zapis wywolania metody abstrakcyjnej z interfejsu (funkcyjnego) = w takim interfejsie musi
         * byc dokladnie jedena metoda abstrakcyjna zeby system mog sie domyslic co chcemy wywolac
         */

        String aaa = "aaa";
        String bbb = "bbb";

        /**
         * adding to implementacja interfejsu StringAdding, nie ma zapisu "override", nie ma nazwy klasy - taka implementacja
         * gdzie nie ma nazwy to klasa anonimowa
         * tak gdzie mamy opertator "->" to to jest lambda
         */


        //Lambda moze zawierac tylko nazwy parametrow bez ich typow jesli typy mozna wywnioskowac
        StringAdding adding = (arg1, arg2) -> {return arg1 + "xxx" + arg2;};
        System.out.println(adding.add(aaa,bbb));
        System.out.println("==============");

        //Lambda moze (czasem musi) zawierac typy parametrow
        StringAdding anotherAdding = (String par1, String par2) -> {return "zzz" + par1 + "uuu" + par2 + "www";};
        System.out.println(anotherAdding.add(aaa,bbb));
        System.out.println("==============");

        //Lambda moze nie zawierac slowa kluczowego return
        StringAdding noReturn = (arg1, arg2) -> arg1 + arg2;
        System.out.println(noReturn.add(aaa,bbb));
        System.out.println("==============");
        System.out.println("==============");
        System.out.println("==============");

        /**
         * Przyklad z istniejacym wczesniej interfejsem i zapis PRE-JAVA8, POST-JAVA8
         */

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("++++++++++++++++++++++++++++++++");
                System.out.println("Wypisanie czegos w osobnym watku");
                System.out.println("++++++++++++++++++++++++++++++++");
            }
        });
        thread.start();

        Thread anotherThread = new Thread(() -> {
            System.out.println("*********************************");
            System.out.println("Tu piszemy tez w osobnym watku");
            System.out.println("*********************************");
        });
        anotherThread.start();



        System.out.println("==============");


    }
}
