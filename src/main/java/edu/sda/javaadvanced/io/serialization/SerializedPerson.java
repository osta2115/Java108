package edu.sda.javaadvanced.io.serialization;

import java.io.Serializable;

/**
 * Serializable jest tak zwanym Flag Interface czyli interfejsem - znacznikiem, co oznacza, ze nie musimy implementowac
 * zadnej metody, abt klasa spelniala ten interfejs, po prostu odblokowujemy dodatkowe mozliwosci dla klasy
 */

public class SerializedPerson implements Serializable {

    /**
     * tansient bedzie oznaczal, ze takie pole ma nie byc pakowane do strumienia podczas serializacji obiektu,
     * a podczas jego odczytywania (deserializacji) zakladamy, ze to pole nie bedzie uzupelnione;
     * system wypelni je wartoscia domyslna (String - null, int - 0, boolean - false itp)
     */

    private transient int id;
    private String name;
    private String surName;
    private int age;

    public SerializedPerson(int id, String name, String surName, int age) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerializedPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}
