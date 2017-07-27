package com.homedepot.training.baseball;

import com.homedepot.training.game.Team;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import com.homedepot.training.game.Game;

public class BaseballGame extends Game
{
//    public static Logger log  = LogManager.getLogger();

    private int   regulationInnings;

    public BaseballGame( String awayTeamName, String homeTeamName, int innings )
    {
        super( awayTeamName, homeTeamName );

        setRegulationGameDuration( innings );
    }

    public BaseballGame( Team awayTeam, Team homeTeam, int innings )
    {
        super( awayTeam, homeTeam );

        setRegulationGameDuration( innings );
     }


    public void play()
    {
//        log.error( "Play not yet implemented" );

        BoxScore boxScore = new BoxScore( this );
        AtBat    atBat    = new AtBat();
        int      batterUp = 0;
        while( !boxScore.isGameOver() )
        {
            ++batterUp;
            System.out.println( "Batter: " + batterUp );
            if ( atBat.getOutcome() == BattingOutcome.OUT )
                boxScore.recordOut();
//            else
//                System.out.println( "Batter: " + batterUp );
            if ( boxScore.isLastOut() )
            {
                boxScore.displayBoxScore();
                boxScore.endHalfInning();
            }

            System.out.println();
        }
    }


    private int setRegulationGameDuration( int maxInnings )
    {
        this.regulationInnings = maxInnings;

        return maxInnings;
    }

    public int getRegulationInnings()
    {
        return regulationInnings;
    }
}
