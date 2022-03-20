package edu.sda.javaadvanced.collections.exercise;

import java.util.Comparator;

public class HumanBySurnameAndNameFromZToAComparator implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        if (!human1.getSurname().equals(human2.getSurname())){
            return human2.getSurname().compareTo(human1.getSurname());
        }
        return human2.getName().compareTo(human1.getName());
    }
}
