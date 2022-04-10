package edu.sda.javaadvanced.exercise;

public class Demo {

    public static void main(String[] args) {

        Salesman salesman1 = new Salesman("Dwight", "Schrute", Gender.MALE);
        Student student1 = new Student("Jan", "Kowalski", Gender.MALE);
        Salesman salesman2 = new Salesman("Martyna", "Wojciechowicz", Gender.FEMALE);
        Student student2 = new Student("Joanna", "Walczak", Gender.FEMALE);


        salesman1.changeTrade("Paper");
        salesman2.changeTrade("AGD");
        student1.chooseStudiesMajor("Mechatronika");
        student2.chooseStudiesMajor("Informatyka");

        salesman1.setFamilyDestiantion("Lublin");
        salesman1.setWorkDestination("Warszawa");
        salesman1.setWorking(true);


        salesman2.setFamilyDestiantion("Poznan");
        salesman2.setWorkDestination("Szczecin");
        salesman2.setWorking(false);



        student1.adjustLocation("m");
        student2.adjustLocation("l");
        salesman1.adjustLocation("a");
        salesman2.adjustLocation("j");


        System.out.println("Student 1 plywa?: " + student1.sail());
        try {
            System.out.println("Student 2 plywa?: " + student2.sail());
        } catch (Exception e){
            System.out.println("olac wyjatki");
        }

        System.out.println(salesman1.getLastName() + " jedzie do " + salesman1.driveTo() + " bo kierunek to " + (salesman1.isWorking() ? "praca" : "dom"));
        System.out.println(salesman2.getLastName() + " jedzie do " + salesman2.driveTo() + " bo kierunek to " + (salesman2.isWorking() ? "praca" : "dom"));
    }
}
