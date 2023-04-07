package com.sportradar.scoreboard.football;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.operations.IGetMatch;

public class GetFootBallMatch implements IGetMatch {

	@Override
	public List<ScoreBoard> getGamesOrderedByTotalScore(Map<String, ScoreBoard> scoreBoard) {
		List<ScoreBoard> scoreBoardList = scoreBoard.values().stream()
				.filter(singleScoreCard -> singleScoreCard.getHomeTeamScore() + singleScoreCard.getAwayTeamScore() > 0)
				.collect(Collectors.toList());
		scoreBoardList.sort(Comparator.comparing(ScoreBoard::getTotalScore).reversed()
				.thenComparing(Comparator.comparing(ScoreBoard::getStartTime).reversed()));
		return scoreBoardList;
	}

}
