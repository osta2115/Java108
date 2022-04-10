package edu.sda.javaadvanced.collections.exercise;

public enum Gennder {
    MALE(2),
    FEMALE(1);

    private int index;

    Gennder(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
