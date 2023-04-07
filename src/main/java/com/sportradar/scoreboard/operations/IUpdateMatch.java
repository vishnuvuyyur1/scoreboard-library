package com.sportradar.scoreboard.operations;

import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;

public interface IUpdateMatch {
	void updateScores(Map<String, ScoreBoard> scoreBoard, String matchId, int homeTeamScore, int awayTeamScore);
}
