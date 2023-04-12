package com.sportradar.scoreboard.orchestrator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;
import com.sportradar.scoreboard.operations.IGetMatch;
import com.sportradar.scoreboard.operations.IStartMatch;
import com.sportradar.scoreboard.operations.IStopMatch;
import com.sportradar.scoreboard.operations.IUpdateMatch;

public class FootballOrchestrator {
	private Map<String, ScoreBoard> footballScoreBoard;
	private final IGetMatch getFootBall;
	private final IStartMatch startFootball;
	private final IStopMatch stopFootball;
	private final IUpdateMatch updateFootball;

	public FootballOrchestrator(IGetMatch getFootBall, IStartMatch startFootball, IStopMatch stopFootball,
			IUpdateMatch updateFootball) {
		this.getFootBall = getFootBall;
		this.startFootball = startFootball;
		this.stopFootball = stopFootball;
		this.updateFootball = updateFootball;
		this.footballScoreBoard = new HashMap<>();
		;
	}

	public String startNewGame(Team homeTeam, Team awayTeam) {
		return startFootball.startGame(this.footballScoreBoard, homeTeam, awayTeam);
	}

	public void stopGame(String matchId) {
		stopFootball.finishGame(this.footballScoreBoard, matchId);
	}

	public void updateScores(String matchId, int homeTeamScore, int awayTeamScore) {
		updateFootball.updateScores(this.footballScoreBoard, matchId, homeTeamScore, awayTeamScore);
	}

	public List<ScoreBoard> getGames() {
		return getFootBall.getGamesOrderedByTotalScore(this.footballScoreBoard);
	}
}
