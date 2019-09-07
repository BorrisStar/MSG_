package mygames.service;


import mygames.model.Game;

import java.util.List;

public interface GameService {
	List<Game> allGames(int page);
	void add(Game game);
	void delete(Game game);
	void edit(Game game);
	Game getById(int id);

	int gamesCount();

	boolean checkGame(String game);
}
