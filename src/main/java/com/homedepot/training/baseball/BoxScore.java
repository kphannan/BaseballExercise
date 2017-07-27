package com.homedepot.training.baseball;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BoxScore
{
    private BaseballGame game;
    private int          currentHalfInning;
    private int          outs;
    private int          currentInning;

    private static Logger log         = LogManager.getLogger();
    private static Logger scoreboard  = LogManager.getLogger( "BoxScore" );

    public BoxScore( BaseballGame game )
    {
        this.game = game;
        currentHalfInning = 1;
        outs              = 0;
    }


    /**
     *                | 1 | 2 | 3 | Runs
     *   -------------+---+---+---+---------
     *      awayTeam? |   |   |   |
     *      homeTeam? |   |   |   |
     */
    public void displayBoxScore()
    {
//        System.out.println( game.getAwayTeamName() + " v. " + game.getHomeTeamName() );

        StringBuilder  header                = new StringBuilder();
        StringBuilder  awayTeamBoxScore      = new StringBuilder();
        StringBuilder  homeTeamBoxScore      = new StringBuilder();

//        for ( int row = 0; row < 3; ++row )
//        {
            for ( int inning = 0; inning <= game.getRegulationInnings() + 1; ++inning )
            {
                String text = "";
                if ( inning == 0 )
                {
//                    if ( row == 1 )
//                    {
                        awayTeamBoxScore.append( game.getAwayTeamName() );
                        if ( currentHalfInning % 2 == 1 ) awayTeamBoxScore.append( '>' );
//                    }
//                    else if ( row == 2 )
//                    {
                        homeTeamBoxScore.append( game.getHomeTeamName() );
                        if ( currentHalfInning % 2 == 0 ) homeTeamBoxScore.append( '>' );
//                    }

//                    for ( int space = 15 - text.length(); space > 0; --space )
//                    {
//                        System.out.print( ' ' );
//                    }
                }
                // Total runs
                else if ( inning == game.getRegulationInnings() + 1 )
                {
                    header.append( "Runs" );
//                    text = "Runs";
                }
                else if ( inning == game.getRegulationInnings() + 2 )
                {
                    header.append( "Hits" );
                    continue;
                }
                else if ( inning == game.getRegulationInnings() + 3 )
                {
                    header.append( "Errors" );
                    continue;
                }
                // Team score
                else
                {
//                    if ( row == 0 )
                        header.append( " " + inning );
//                    else
//                    {
                        if ( currentHalfInning / 2 < inning )
                        {
                            if ( currentHalfInning % 2 == 1 )
                                awayTeamBoxScore.append( " 0" );
                            else
                                awayTeamBoxScore.append( "  " );
                            if ( currentHalfInning % 2 == 0 )
                                homeTeamBoxScore.append( " 0" );
                            else
                                homeTeamBoxScore.append( "  " );
                            text = " 0";
                        }
//                        else
//                            text = "  ";
//                    }
                }

                log.info( text );
                log.info( " |" );
//                scoreboard.info( text );
//                scoreboard.info( " |" );
            }

        scoreboard.info( header );
        scoreboard.info( awayTeamBoxScore );
        scoreboard.info( homeTeamBoxScore );
            log.info("");
            scoreboard.info("");
//        }
    }

    public void recordOut()
    {
        ++outs;
    }

    public boolean isLastOut()
    {
        return outs > 2;
    }

    public void endHalfInning()
    {
        ++currentHalfInning;
        outs = 0;
    }

    public boolean isEndOfRegulation()
    {
        return currentHalfInning > 2 * game.getRegulationInnings();
    }

    public boolean isGameOver()
    {
        return isEndOfRegulation();
    }
}
