package edu.sda.javaadvanced.generics;

public abstract class Team implements Comparable<Team>{

    private String name;
    private int points;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(Team team) {
        return team.getPoints() - this.points;
    }
}
