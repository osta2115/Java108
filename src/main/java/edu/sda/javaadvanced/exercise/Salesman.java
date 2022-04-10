package edu.sda.javaadvanced.exercise;

public class Salesman extends Human implements Driver{

    private String trade;
    private String workDestination;
    private String familyDestiantion;
    private boolean isWorking;

    public Salesman(String name, String lastName, Gender gender) {
        super(name, lastName, gender);
    }

    public String getTrade() {
        return trade;
    }

    // to jest setter nazywany tak zeby bylo wiadomo o co chodzi
    public void changeTrade(String trade){
        this.trade = trade;
    }

    public void setWorkDestination(String workDestination) {
        this.workDestination = workDestination;
    }

    public void setFamilyDestiantion(String familyDestiantion) {
        this.familyDestiantion = familyDestiantion;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public boolean isWorking() {
        return isWorking;
    }

    @Override
    public String driveTo() {
        return isWorking ? workDestination : familyDestiantion;
    }
}
