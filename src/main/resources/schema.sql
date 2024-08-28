CREATE TABLE IF NOT EXISTS scores (
    id SERIAL PRIMARY KEY,
		name VARCHAR(255),
		total_time VARCHAR(255),
		total_gold_spent VARCHAR(255),
		total_gold_earned VARCHAR(255),
		total_kills VARCHAR(255)
);