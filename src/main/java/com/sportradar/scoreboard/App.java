package com.sportradar.scoreboard;

import java.util.logging.Logger;

import com.sportradar.scoreboard.football.GetFootBallMatch;
import com.sportradar.scoreboard.football.StartStopFootballMatch;
import com.sportradar.scoreboard.football.UpdateFootballMatch;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.orchestrator.FootballOrchestrator;

public class App 
{
	private final static Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
    	FootballOrchestrator orc = new FootballOrchestrator(new GetFootBallMatch(), new StartStopFootballMatch(), new UpdateFootballMatch());
    	//Test case 1
    	orc.updateScores(orc.startNewGame(Team.Mexico, Team.Canada), 0, 5);
    	orc.updateScores(orc.startNewGame(Team.Spain, Team.Brazil), 10, 2);
    	orc.updateScores(orc.startNewGame(Team.Germany, Team.France), 2, 2);
    	orc.updateScores(orc.startNewGame(Team.Uruguay, Team.Italy), 6, 6);
    	orc.updateScores(orc.startNewGame(Team.Argentina, Team.Australia), 3, 1);
    	orc.getGames().stream().forEach(score -> LOGGER.info(score.toString()));
   
    	//Test case 2
    	orc.updateScores(orc.startNewGame(Team.Germany, Team.Spain), 2, 5);
    	orc.updateScores(orc.startNewGame(Team.Argentina, Team.Brazil), 1, 9);
    	orc.updateScores(orc.startNewGame(Team.Canada, Team.France), 3, 6);
    	orc.getGames().stream().forEach(score -> LOGGER.info(score.toString()));
    }
}
