package edu.sda.javaadvanced.collections.exercise;

import java.util.Comparator;

public class HumanByAgeAndNameComparator implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        if (human1.getAge() != human2.getAge()){
            return human1.getAge() - human2.getAge();
        }
        return human1.getName().compareTo(human2.getName());

    }
}
