package com.sportradar.scoreboard.testdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sportradar.scoreboard.model.ScoreBoard;
import com.sportradar.scoreboard.model.Team;

public class ScoreBoardTestData {
	public static Map<String, ScoreBoard>  getScoreBoard(){
		Map<String, ScoreBoard> scoreBoard = new HashMap<>();
		scoreBoard.put("match1", ScoreBoard.builder().homeTeam(Team.Argentina).homeTeamScore(2).awayTeam(Team.Australia).awayTeamScore(1).totalScore(3).build());
		scoreBoard.put("match2", ScoreBoard.builder().homeTeam(Team.Brazil).homeTeamScore(2).awayTeam(Team.Canada).awayTeamScore(3).totalScore(5).build());
		return scoreBoard;
	}
	
	public static List<ScoreBoard>  getScoreBoardList(){
		return List.of(ScoreBoard.builder().homeTeam(Team.Argentina).homeTeamScore(2).awayTeam(Team.Australia).awayTeamScore(1).totalScore(3).build(),
				ScoreBoard.builder().homeTeam(Team.Brazil).homeTeamScore(2).awayTeam(Team.Canada).awayTeamScore(3).totalScore(5).build());
	}
}
