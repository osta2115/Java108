package edu.sda.javaadvanced.collections.exercise;

import edu.sda.javaadvanced.exercise.Gender;

import java.util.Objects;

public class Human implements Comparable<Human>{
    private String name;
    private String surname;
    private Gennder gender;
    private int age;

    public Human(String name, String surname, Gennder gender, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gennder getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getHumanInfo() {
        return new StringBuilder("Name: ")
                .append(name)
                .append(" , Surname: ")
                .append(surname)
                .append(" , gender: ")
                .append(gender)
                .append(" , age: ")
                .append(age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return age == human.age && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, gender, age);
    }

    @Override
    public int compareTo(Human human) {
        return surname.compareTo(human.getSurname());
    }
}
