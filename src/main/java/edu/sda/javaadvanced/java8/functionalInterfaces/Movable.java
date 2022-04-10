package edu.sda.javaadvanced.java8.functionalInterfaces;

/**
 * Adnotacja FunctionalInterface okresla ze interfejs moze miec doklanie jedna metode abstrakcyjna (bez ciala)
 * Jesli w interfejsie wystepuje wiecej metod to musza byc one:
 *  - domyslne lub
 *  - prywatne lub
 *  - statyczne
 */
@FunctionalInterface
public interface Movable {
    String move();

    //String slowMove(); - na FunctionalInterface nie przejdzie

    default String moveWith(String partner) {
        return move() + " with " + partner;
    }

}
