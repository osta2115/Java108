package edu.sda.javaadvanced.collections.exercise;

import java.util.List;

public class HumanReportPrinter extends Thread{
    private List<Human> listofPeople;

    public HumanReportPrinter(List<Human> listofPeople) {
        this.listofPeople = listofPeople;
    }

    @Override
    public synchronized void run() {

        for (Human human : listofPeople) {
            System.out.println(human.getHumanInfo());
        }
    }

}
