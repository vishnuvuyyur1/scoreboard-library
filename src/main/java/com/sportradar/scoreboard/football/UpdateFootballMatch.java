package com.sportradar.scoreboard.football;

import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.operations.IUpdateMatch;

public class UpdateFootballMatch implements IUpdateMatch {

	@Override
	public void updateScores(Map<String, ScoreBoard> scoreBoard, String matchId, int homeTeamScore, int awayTeamScore) {
		updateScoresForOneMatch(scoreBoard.get(matchId), homeTeamScore, awayTeamScore);
	}

	private void updateScoresForOneMatch(ScoreBoard scoreBoard, int homeTeamScore, int awayTeamScore) {
		if (scoreBoard != null) {
			scoreBoard.setHomeTeamScore(homeTeamScore);
			scoreBoard.setAwayTeamScore(awayTeamScore);
			scoreBoard.setTotalScore(homeTeamScore + awayTeamScore);
		} else {
			throw new IllegalArgumentException("Invalid Match Id");
		}
	}

}
