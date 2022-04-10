package edu.sda.javaadvanced.generics.fullGeneric;

import edu.sda.javaadvanced.generics.FootballTeam;
import edu.sda.javaadvanced.generics.Team;
import edu.sda.javaadvanced.generics.TeamLevel;
import edu.sda.javaadvanced.generics.VolleyballTeam;


public class LeagueMain {
    public static void main(String[] args) {
        League<Team> league = new League("Primiera Division");
        Team team1 = new FootballTeam("Real Madrid", TeamLevel.PROFESSIONAL);
        Team team2 = new FootballTeam("Fc Barcelona", TeamLevel.AMATEUR);
        Team team3 = new FootballTeam("Atletico Madrid", TeamLevel.PROFESSIONAL);
        Team team4 = new FootballTeam("Valencia CF", TeamLevel.PROFESSIONAL);

        team1.setPoints(69);
        team2.setPoints(15);
        team3.setPoints(60);
        team4.setPoints(51);

        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);
        System.out.println("==================");
        league.printTable();
        System.out.println("==================");

        Team team5 = new VolleyballTeam("Asseco Resovia", TeamLevel.PROFESSIONAL);
        league.addTeam(team5);
        team5.setPoints(27);
        league.printTable();
    }
}
