package dev.yoannjob.fakeapi.api.score;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.simple.JdbcClient;

import org.springframework.stereotype.Repository;


@Repository
public class ScoreRepository {
	private static final Logger log = LoggerFactory.getLogger(ScoreRepository.class);
  private final JdbcClient jdbcClient;

  public ScoreRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
    log.info("ScoreRepository initialized");
  }

	public List<Score> findAll() {
		return jdbcClient.sql("SELECT * FROM scores ORDER BY id DESC LIMIT 3")
			.query(Score.class)
			.list();
	}

	public Score create(Score score) {
		jdbcClient.sql("INSERT INTO scores (name, total_time, total_gold_spent, total_gold_earned, total_kills) VALUES (:name, :totalTime, :totalGoldSpent, :totalGoldEarned, :totalKills)")
			.param("name", score.name())
			.param("totalTime", score.totalTime())
			.param("totalGoldSpent", score.totalGoldSpent())
			.param("totalGoldEarned", score.totalGoldEarned())
			.param("totalKills", score.totalKills())
			.update();
	
		return score;
	}

	public void deleteAll() {
		jdbcClient.sql("DELETE FROM scores")
			.update();
	}

	public void deleteById(Long id) {
		jdbcClient.sql("DELETE FROM scores WHERE id = :id")
			.param("id", id)
			.update();
	}
}
