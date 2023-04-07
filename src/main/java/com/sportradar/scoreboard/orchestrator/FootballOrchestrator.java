package com.sportradar.scoreboard.orchestrator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportradar.scoreboard.football.GetFootBallMatch;
import com.sportradar.scoreboard.football.StartStopFootballMatch;
import com.sportradar.scoreboard.football.UpdateFootballMatch;
import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;

public class FootballOrchestrator {
	private Map<String, ScoreBoard> footballScoreBoard;
	private final GetFootBallMatch getFootBall;
    private final StartStopFootballMatch startStopFootball;
    private final UpdateFootballMatch updateFootball;
	
    public FootballOrchestrator(GetFootBallMatch getFootBall, StartStopFootballMatch startStopFootball,
			UpdateFootballMatch updateFootball) {
		this.getFootBall = getFootBall;
		this.startStopFootball = startStopFootball;
		this.updateFootball = updateFootball;
		this.footballScoreBoard = new HashMap<>();;
	}
    
    public String startNewGame(Team homeTeam, Team awayTeam) {
    	return startStopFootball.startGame(this.footballScoreBoard, homeTeam, awayTeam);
    }
    
    public void stopGame(String matchId) {
        startStopFootball.finishGame(this.footballScoreBoard, matchId);
    }
    
    public void updateScores(String matchId, int homeTeamScore, int awayTeamScore) {
    	updateFootball.updateScores(this.footballScoreBoard, matchId, homeTeamScore, awayTeamScore);
    } 
    
    public List<ScoreBoard> getGames() {
    	return getFootBall.getGamesOrderedByTotalScore(this.footballScoreBoard);
    }
}
