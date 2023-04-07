package com.sportradar.scoreboard.operations;

import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;

public interface IStopMatch {
	void finishGame(Map<String, ScoreBoard> scoreBoard, String matchId);
}
