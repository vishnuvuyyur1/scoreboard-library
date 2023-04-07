package com.sportradar.scoreboard.orchestrator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.sportradar.scoreboard.football.GetFootBallMatch;
import com.sportradar.scoreboard.football.StartStopFootballMatch;
import com.sportradar.scoreboard.football.UpdateFootballMatch;
import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.testdata.ScoreBoardTestData;

public class FootballOrchestratorTest {
	@InjectMocks
	private FootballOrchestrator footballOrchestrator;

	@Mock
	private GetFootBallMatch getFootBall;
	@Mock
	private StartStopFootballMatch startStopFootball;
	@Mock
	private UpdateFootballMatch updateFootball;

	@Test
	void testStartNewGame() {
		when(startStopFootball.startGame(any(), any(), any())).thenReturn("match1");
		String result = footballOrchestrator.startNewGame(Team.Argentina, Team.Australia);
		assertEquals("match1", result);
	}
	
	@Test
	void testStopGame() {
		Map<String, ScoreBoard> scoreBoard = new HashMap<>();
		footballOrchestrator.stopGame("matchId");
		verify(startStopFootball, times(1)).finishGame(scoreBoard, "matchId");
	}
	
	@Test
	void testUpdateScores() {
		Map<String, ScoreBoard> scoreBoard = new HashMap<>();
		footballOrchestrator.updateScores("matchId", 2, 3);
		verify(updateFootball, times(1)).updateScores(scoreBoard, "matchId", 2, 3);
	}
	
	@Test
	void testGetGames() {
		when(getFootBall.getGamesOrderedByTotalScore(any())).thenReturn(ScoreBoardTestData.getScoreBoardList());
		List<ScoreBoard> result = footballOrchestrator.getGames();
		assertEquals(2, result.size());
	}
}
