drop database if exists GuessTheNumberDB;
create database GuessTheNumberDB;
use GuessTheNumberDB;
create table games(
	gameId int auto_increment,
		primary key(gameId),
	inProgress boolean not null,
    answer varchar(4) not null,
    player varchar(3) not null
);
create table rounds(
	roundId int auto_increment,
		primary key(roundId),
	gameId int not null,
		foreign key(gameId) references games(gameId),
	guessTime timestamp not null,
    exactMatch int,
    partialMatch int,
    playerGuessCount int
);
