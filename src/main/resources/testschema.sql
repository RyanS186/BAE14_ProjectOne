DROP TABLE IF EXISTS records CASCADE;

CREATE TABLE records (
	id BIGINT AUTO_INCREMENT,
	album_name VARCHAR(255) NOT NULL,
	artist_name VARCHAR(255) NOT NULL,
	genre VARCHAR(255),
	release_year INT,
	PRIMARY KEY (id)
);