package com.homedepot.training.baseball;

public class BoxScore
{
    private BaseballGame game;
    private int          currentHalfInning;
    private int          outs;
    private int          currentInning;

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


        for ( int row = 0; row < 3; ++row )
        {
            for ( int inning = 0; inning <= game.getRegulationInnings() + 1; ++inning )
            {
                String text = "";
                if ( inning == 0 )
                {
                    if ( row == 1 )
                    {
                        text = game.getAwayTeamName();
                        if ( currentHalfInning % 2 == 1 ) text += ">";
                    }
                    else if ( row == 2 )
                    {
                        text = game.getHomeTeamName();
                        if ( currentHalfInning % 2 == 0 ) text += ">";
                    }

                    for ( int space = 15 - text.length(); space > 0; --space )
                    {
                        System.out.print( ' ' );
                    }
                }
                // Total runs
                else if ( row == 0 && inning == game.getRegulationInnings() + 1 )
                {
                    text = "Runs";
                }
                else if ( row == 0 && inning == game.getRegulationInnings() + 2 )
                {
                    text = "Hits";
                    continue;
                }
                else if ( row == 0 && inning == game.getRegulationInnings() + 3 )
                {
                    text = "Errors";
                    continue;
                }
                // Team score
                else
                {
                    if ( row == 0 )
                        text = " " + inning;
                    else
                    {
                        if ( currentHalfInning / 2 < inning )
                            text = " -";
                        else
                            text = "  ";
                    }
                }

                System.out.print( text );
                System.out.print( " |" );
            }

            System.out.println();
        }
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
