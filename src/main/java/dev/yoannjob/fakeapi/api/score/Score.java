package dev.yoannjob.fakeapi.api.score;

public record Score(Integer id,
		String name,
		String totalTime,
		String totalGoldSpent,
		String totalGoldEarned,
		String totalKills) {

}
