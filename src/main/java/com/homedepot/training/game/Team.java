package com.homedepot.training.game;

import java.util.List;

public class Team
{
    private String       name;
    private List<Player> roster;

    public Team( String teamName )
    {
        name   = teamName;
        roster = RosterLoader.loadRoster( teamName );
    }

    public String getTeamName()
    {
        return name;
    }
}
