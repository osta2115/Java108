package edu.sda.javaadvanced.generics.withBoundaries;

import edu.sda.javaadvanced.generics.FootballTeam;
import edu.sda.javaadvanced.generics.Team;
import edu.sda.javaadvanced.generics.TeamLevel;
import edu.sda.javaadvanced.generics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League<FootballTeam> footballLeague = new League<>("Primiera Division");
        League<VolleyballTeam> volleyballLeague = new League<>("Plus Liga");

        FootballTeam team1 = new FootballTeam("Real Madrid", TeamLevel.PROFESSIONAL);
        FootballTeam team2 = new FootballTeam("FC Barcelona", TeamLevel.AMATEUR);
        Team team3 = new FootballTeam("Atletico Madrid", TeamLevel.PROFESSIONAL);
        Team team4 = new FootballTeam("Valencia", TeamLevel.PROFESSIONAL);
        team1.setPoints(60);
        team2.setPoints(30);
        team3.setPoints(40);
        team4.setPoints(50);
        footballLeague.addTeam(team1);
        footballLeague.addTeam(team2);
        footballLeague.addTeam((FootballTeam) team3); //football league jest okreslona jako  League<FootballTeam>
        //więc jawnie trzeba powiedzieć kompilatorowi, że team 3 ma traktować jako FootballTeam
        footballLeague.addTeam((FootballTeam) team4);
        footballLeague.addTeam(team1);
        System.out.println("====================");
        footballLeague.printTable();
        System.out.println("====================");
    }
}
