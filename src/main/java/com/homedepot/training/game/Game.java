package com.homedepot.training.game;

abstract public class Game
{
    private Team    awayTeam;
    private Team    homeTeam;

    public Game( String awayTeamName, String homeTeamName )
    {
        awayTeam = new Team( awayTeamName );
        homeTeam = new Team( homeTeamName );
    }

    public Game( Team awayTeam, Team homeTeam )
    {
        this.awayTeam = awayTeam;
        this.homeTeam = homeTeam;
    }

    public String getAwayTeamName()
    {
        return awayTeam.getTeamName();
    }

    public String getHomeTeamName()
    {
        return homeTeam.getTeamName();
    }

    public abstract void play();
}
