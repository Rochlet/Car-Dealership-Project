drop database if exists guessTheNumberDB;
create database guessTheNumberDB;
use guessTheNumberDB;
create table games(
	gameId int auto_increment,
		primary key(gameId),
	inProgress boolean not null,
    answer varchar(4) not null,
    player varchar(3) not null
);


INSERT INTO games(answer,inProgress,player) VALUES
	("1234", true,"xyz"),
	("5678", true,"fgh"),
	("9123", true,"asd");
    
    
create table rounds(
	roundId int auto_increment,
		primary key(roundId),
	gameId int default 1,
		foreign key(gameId) references games(gameId),
	guessTime timestamp not null,
    exactMatch int,
    partialMatch int,
    playerGuessCount int
);

INSERT INTO rounds(guessTime,exactMatch,partialMatch,playerGuessCount) VALUES
    ("2019-06-02 09:11:07", 1,2,2),
    ( "2019-06-04 09:11:49", 3,1,2),
    ( "2019-08-28 02:42:55", 2,2,6),
    ( "2019-08-28 02:43:12", 9,3,3);
    
