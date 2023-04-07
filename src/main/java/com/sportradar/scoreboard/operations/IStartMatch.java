package com.sportradar.scoreboard.operations;

import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;

public interface IStartMatch {
	String startGame(Map<String, ScoreBoard> scoreBoard, Team homeTeam, Team awayTeam);
}
