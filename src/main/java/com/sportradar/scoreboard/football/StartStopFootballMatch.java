package com.sportradar.scoreboard.football;

import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.operations.IStartMatch;
import com.sportradar.scoreboard.operations.IStopMatch;

public class StartStopFootballMatch implements IStartMatch,  IStopMatch {
	private static final int INITIAL_SCORES = 0;

	@Override
	public String startGame(Map<String, ScoreBoard> scoreBoard, Team homeTeam, Team awayTeam) {
		String matchId = homeTeam.toString() + awayTeam.toString();
		scoreBoard.put(matchId, ScoreBoard.builder().homeTeam(homeTeam).homeTeamScore(INITIAL_SCORES).awayTeam(awayTeam)
				.awayTeamScore(INITIAL_SCORES).startTime(System.currentTimeMillis()).build());
		return matchId;
	}

	@Override
	public void finishGame(Map<String, ScoreBoard> scoreBoard, String matchId) {
		// TODO Auto-generated method stub
		
	}

}
