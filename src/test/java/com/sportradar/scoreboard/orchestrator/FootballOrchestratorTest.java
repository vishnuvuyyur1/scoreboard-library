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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.operations.IGetMatch;
import com.sportradar.scoreboard.operations.IStartMatch;
import com.sportradar.scoreboard.operations.IStopMatch;
import com.sportradar.scoreboard.operations.IUpdateMatch;
import com.sportradar.scoreboard.testdata.ScoreBoardTestData;

@ExtendWith(MockitoExtension.class)
public class FootballOrchestratorTest {
	@InjectMocks
	private FootballOrchestrator footballOrchestrator;

	@Mock
	private IGetMatch getFootBall;
	@Mock
	private  IStartMatch startFootball;
	@Mock
	private  IStopMatch stopFootball;
	@Mock
	private  IUpdateMatch updateFootball;

	@Test
	void testStartNewGame() {
		when(startFootball.startGame(any(), any(), any())).thenReturn("match1");
		String result = footballOrchestrator.startNewGame(Team.Argentina, Team.Australia);
		assertEquals("match1", result);
	}
	
	@Test
	void testStopGame() {
		Map<String, ScoreBoard> scoreBoard = new HashMap<>();
		footballOrchestrator.stopGame("matchId");
		verify(stopFootball, times(1)).finishGame(scoreBoard, "matchId");
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
