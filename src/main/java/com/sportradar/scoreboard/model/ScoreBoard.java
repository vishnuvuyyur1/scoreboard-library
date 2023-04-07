package com.sportradar.scoreboard.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ScoreBoard {
	Team homeTeam;
	int homeTeamScore;
	Team awayTeam;
	int awayTeamScore;
	long startTime;
	int totalScore;
	
	public String toString() {
		return homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore;
	}
}
