package dev.yoannjob.fakeapi.api.score;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api")
public class ScoreController {
  private static final Logger log = LoggerFactory.getLogger(ScoreController.class);
  private final ScoreRepository scoreRepository;

  public ScoreController(ScoreRepository scoreRepository) {
    this.scoreRepository = scoreRepository;
    log.info("scoreController initialized");
  }

	
	@GetMapping("/ping")
	@CrossOrigin
	public Map<String, String> ping() {
		HashMap<String, String> pong = new HashMap<>();
		pong.put("message", "pong");
		return pong;
	}

	@GetMapping("/scores")
	@CrossOrigin
	public List<Score> findAll() {
		return scoreRepository.findAll();
	}

	@PostMapping("/scores")
	@CrossOrigin
	@ResponseStatus(HttpStatus.CREATED)
	public Score create(@Valid @RequestBody Score score) {
		return scoreRepository.create(score);
	}

	@DeleteMapping("/scores")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteAll() {
		scoreRepository.deleteAll();
	}

	@DeleteMapping("/scores/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {
		scoreRepository.deleteById(id);
	}
}

