package edu.sda.javaadvanced.innerClasses.anonymous;

public class ShoutableUse {

    void shoutOnSomebody() {

        /**
         * tu mamy tworzenie klasy anonimowej, czyli obiektu ktory spelnia interfejs shoutable, ale nie ma okreslonego
         * typu klasy, czyli nie ma konwencji "class ShoutnigPerson implements Shoutable{}
         */

        Shoutable shoutable = new Shoutable() {
            @Override
            public String shout() {
                return "Yelling at yaaaaa!!!!";
            }
        };
        System.out.println(shoutable.shout());

        /**
         * powyzsze mozna (i Inteliiij sugeruje) zeby zamienic na lambde
         */

        Shoutable lambdaShoutable = () -> "Lambda yelling on ya";
        System.out.println(lambdaShoutable.shout());
    }
}
