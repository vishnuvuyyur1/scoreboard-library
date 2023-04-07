package com.sportradar.scoreboard.operations;

import java.util.List;
import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;

public interface IGetMatch {
	List<ScoreBoard> getGamesOrderedByTotalScore(Map<String, ScoreBoard> scoreBoard);
}
