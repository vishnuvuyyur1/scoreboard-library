package com.sportradar.scoreboard.football;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.testdata.ScoreBoardTestData;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StartStopFootballMatchTest {
	private StartStopFootballMatch startStopFootballMatch;

	@BeforeAll
	public void createFootball() {
		startStopFootballMatch = new StartStopFootballMatch();
	}
	
	@Test
	void testStartGame() {
		Map<String, ScoreBoard> scoreBoard = new HashMap<>();
		String matchId = startStopFootballMatch.startGame(scoreBoard, Team.Canada, Team.France);
		String expectedMatchId = Team.Canada.toString()+Team.France.toString();
		assertEquals(expectedMatchId, matchId);
		assertEquals(Team.Canada, scoreBoard.get(expectedMatchId).getHomeTeam());
		assertEquals(0, scoreBoard.get(expectedMatchId).getHomeTeamScore());
	}
	
	@Test
	void testFinishGame() {
		Map<String, ScoreBoard> scoreBoard = ScoreBoardTestData.getScoreBoard();
		startStopFootballMatch.finishGame(scoreBoard, "match1");
		assertNull(scoreBoard.get("match1"));
	}
}
