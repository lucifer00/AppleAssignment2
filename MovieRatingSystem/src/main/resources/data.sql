
CREATE TABLE IF NOT EXISTS movie (
  movie_id INT PRIMARY KEY,
  movie_name VARCHAR(100) NOT NULL
);

INSERT INTO movie(movie_id,movie_name) values (1,'Spider Man'),(2,'Bat Man');

CREATE TABLE IF NOT EXISTS customer(
	customer_id INT PRIMARY KEY,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL
);

INSERT INTO customer(customer_id,first_name,last_name) values (1,'Prashant','Jha'),(2,'Sushant','Jha');