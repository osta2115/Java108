package edu.sda.javaadvanced.generics;

public class FootballTeam extends Team{

    private TeamLevel teamlevel;

    public FootballTeam(String name, TeamLevel teamlevel) {
        super(name);
        this.teamlevel = teamlevel;
    }

    public TeamLevel getTeamlevel() {
        return teamlevel;
    }
}
