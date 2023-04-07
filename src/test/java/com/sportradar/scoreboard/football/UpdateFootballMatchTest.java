package com.sportradar.scoreboard.football;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.testdata.ScoreBoardTestData;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UpdateFootballMatchTest {
	private UpdateFootballMatch updateFootballMatch;

	@BeforeAll
	public void createFootball() {
		updateFootballMatch = new UpdateFootballMatch();
	}
	
	@Test
	void testUpdateScores() {
		Map<String, ScoreBoard> scoreBoard = ScoreBoardTestData.getScoreBoard();
		updateFootballMatch.updateScores(scoreBoard, "match1", 2, 3);
		assertEquals(5, scoreBoard.get("match1").getTotalScore());
		assertEquals(3, scoreBoard.get("match1").getAwayTeamScore());
	}
}
