package mygames.service;


import mygames.dao.GameDAO;
import mygames.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

	//private GameDAO gameDAO = new GameDAOImpl();
	private GameDAO gameDAO;


	@Autowired
	public void setGameDAO(GameDAO gameDAO) {
		this.gameDAO = gameDAO;
	}

	@Override
	@Transactional(isolation = Isolation.DEFAULT)
	public List<Game> allGames(int page) {
		return gameDAO.allGames( page);
	}

	@Override
	@Transactional
	public void add(Game game) {
		gameDAO.add(game);
	}

	@Override
	@Transactional
	public void delete(Game game) {
		gameDAO.delete(game);
	}

	@Override
	@Transactional
	public void edit(Game game) {
		gameDAO.edit(game);
	}

	@Override
	@Transactional
	public Game getById(int id) {
		return gameDAO.getById(id);
	}

	@Override
	@Transactional
	public int gamesCount() {
		return gameDAO.gamesCount();
	}

	@Override
	@Transactional
	public boolean checkGame(String game) {
		return gameDAO.checkGame(game);
	}

	@Override
	@Transactional
	public List<Game> newGames(int page) {
		return gameDAO.newGames(page);
	}
}
