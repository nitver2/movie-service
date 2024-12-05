CREATE TABLE IF NOT EXISTS movie (
    movie_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    language VARCHAR(50) NOT NULL,
    duration INT NOT NULL,
    genre VARCHAR(100) NOT NULL,
    poster_url VARCHAR(500),
    trailer_url VARCHAR(500),
    date TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS theater (
    theater_id INT NOT NULL AUTO_INCREMENT,
    city_id INT NOT NULL,
    name CHAR(50) NOT NULL,
    location CHAR(50) NOT NULL,
    contact_info CHAR(50),
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (theater_id),
    FOREIGN KEY (city_id) REFERENCES city(id)  -- Reference to the city table
);

CREATE TABLE IF NOT EXISTS city (
    city_id INT NOT NULL AUTO_INCREMENT,
    name CHAR(100) NOT NULL,
    state ENUM('MP', 'UP', 'Delhi') NOT NULL,
    PRIMARY KEY (city_id)
);

CREATE TABLE IF NOT EXISTS show (
    show_id INT AUTO_INCREMENT PRIMARY KEY,
    movie_id INT NOT NULL,
    theater_id INT NOT NULL,
    show_time DATETIME NOT NULL,
    available_seats INT NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movie(movie_id),
    FOREIGN KEY (theater_id) REFERENCES theater(theater_id)
);

CREATE TABLE IF NOT EXISTS hall (
    hall_id INT PRIMARY KEY AUTO_INCREMENT,
    theater_id INT NOT NULL,
    capacity INT NOT NULL,
    CONSTRAINT fk_theater FOREIGN KEY (theater_id) REFERENCES theater(theater_id) ON DELETE CASCADE
);




