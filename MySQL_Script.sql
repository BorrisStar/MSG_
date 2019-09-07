USE gamesdb;

CREATE TABLE games
(
  id int(10) PRIMARY KEY AUTO_INCREMENT,
  game VARCHAR(50) NOT NULL,
  year int(4),
  genre VARCHAR(20),
  developer VARCHAR(50),
  processor VARCHAR(50),
  videocard VARCHAR(50),
  memory VARCHAR(10),
  freesize VARCHAR(10),
  price VARCHAR(15),
  launcher VARCHAR(50),
  installed BIT DEFAULT false  NOT NULL
)
COLLATE='utf8_general_ci';
CREATE UNIQUE INDEX games_title_uindex ON games (game);

INSERT INTO `games` (`game`,`year`,`genre`, 'developer', 'processor', 'videocard', 'memory', 'freesize', 'price', 'launcher', 'installed')
VALUES
  ("The Witcher 3: Wild Hunt", 2015, "RPG",  "CD Projekt RED","Intel Core i5-2500K 3.3GHz","Nvidia GeForce GTX 660","6 GB","40 GB","2499.0","thewitcher.com",false)


