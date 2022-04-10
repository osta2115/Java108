package edu.sda.javaadvanced.innerClasses.localClass;

public class LocalClassTest {
    public static void main(String[] args) {

        /**
         * Klasa lokalna jst powoliwana wewnatrz metody i ma dostep do rzeczy wewnatrze tej metody
         * i jest widoczna tylko w kontekscie tej metody
         */

        class LocalPerson {
            private String personName;

            public LocalPerson(String personName) {
                this.personName = personName;
            }

            public String getPersonName() {
                return personName;
            }
        }

        LocalPerson localPerson = new LocalPerson("Osoba lokalna");
        System.out.println(localPerson.getPersonName());
    }
}
