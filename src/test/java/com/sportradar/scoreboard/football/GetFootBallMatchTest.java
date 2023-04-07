package com.sportradar.scoreboard.football;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.testdata.ScoreBoardTestData;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GetFootBallMatchTest {
	private GetFootBallMatch getFootBallMatch;

	@BeforeAll
	public void createFootball() {
		getFootBallMatch = new GetFootBallMatch();
	}
	
	@Test
	void testGetGames() {
		List<ScoreBoard> scoreBoardList = getFootBallMatch.getGamesOrderedByTotalScore(ScoreBoardTestData.getScoreBoard());
		assertEquals(2, scoreBoardList.size());
		assertEquals(Team.Brazil, scoreBoardList.get(0).getHomeTeam());
		assertEquals(Team.Argentina, scoreBoardList.get(1).getHomeTeam());
	}
}
