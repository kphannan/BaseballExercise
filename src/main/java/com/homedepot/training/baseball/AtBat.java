package com.homedepot.training.baseball;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;



public class AtBat
{
    private static Logger log = LogManager.getLogger();

    Random   chance = new Random();
    // convert a random number in to an at bat outcome
    public BattingOutcome getOutcome()
    {
        int percent = chance.nextInt( 100 );
        String outcomeName = "xxx";
        BattingOutcome outcome = BattingOutcome.OUT;

        // Single 17%
        // Double  7%
        // Triple  2%
        // HomeRun 4%
        // Remainder 70% Out

        if ( (percent -= 70) < 0 )      // Out   70%
        {
            outcomeName = "Out";
            outcome = BattingOutcome.OUT;
        }
        else if ((percent -= 17) < 0 )      // Single
        {
            outcomeName = "Single";
            outcome = BattingOutcome.SINGLE;
        }
        else if ((percent -=  7) < 0 )      // Double
        {
            outcomeName = "Double";
            outcome = BattingOutcome.DOUBLE;
        }
        else if ( (percent -=  4) < 0 )      // Home Run
        {
            outcomeName = "Home Run";
            outcome = BattingOutcome.HOMERUN;
        }
        else if ((percent -=  2) < 0 )      // Triple
        {
            outcomeName = "Out";
            outcome = BattingOutcome.TRIPLE;
        }


        log.debug( outcomeName );

        return outcome;
    }
}
