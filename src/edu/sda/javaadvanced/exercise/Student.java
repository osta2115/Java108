package edu.sda.javaadvanced.exercise;

public class Student extends Human implements Driver {

    private String studiesMajor;

    public Student(String name, String lastName, Gender gender) {
        super(name, lastName, gender);
    }

    public String getStudiesMajor() {
        return studiesMajor;
    }

    public void chooseStudiesMajor(String studiesMajor) {
        this.studiesMajor = studiesMajor;
    }

    @Override
    public String driveTo() {
        return "Do domu i po kaske";
    }

}
