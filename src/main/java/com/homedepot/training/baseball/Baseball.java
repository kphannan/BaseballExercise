package com.homedepot.training.baseball;

import com.homedepot.training.game.Game;
import com.homedepot.training.game.Team;

public class Baseball
{
    public static void main( String args[] )
    {
        Team homeTeam = new Team( "Braves" );
        Team awayTeam = new Team("Cardinals" );

        Game game = new BaseballGame( awayTeam, homeTeam, 3 );

        game.play();

    }
}
