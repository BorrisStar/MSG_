package mygames.dao;

import mygames.model.Game;

import java.util.List;


public interface GameDAO {
	List<Game> allGames(int page);//Вернуть названия всех игр
	void add(Game game);
	void delete(Game game);
	void edit(Game game);
	Game getById(int id);//Получить игру по id

	int gamesCount();

	boolean checkGame(String game);
}
