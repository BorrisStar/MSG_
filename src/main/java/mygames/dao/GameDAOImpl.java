package mygames.dao;

import mygames.model.Game;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class GameDAOImpl implements GameDAO {
	private static final AtomicInteger AUTO_ID = new AtomicInteger(0);// Чтобы использовать автоинкремент

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Game> allGames(int page) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Game").setFirstResult(10*(page - 1)).setMaxResults(10).list();
	}

	@Override
	public void add(Game game) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(game);

	}

	@Override
	public void delete(Game game) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(game);

	}

	@Override
	public void edit(Game game) {
		Session session = sessionFactory.getCurrentSession();
		session.update(game);

	}

	@Override
	public Game getById(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Game.class,id);

	}

	@Override
	public int gamesCount() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select count(*) from Game", Number.class).getSingleResult().intValue();
	}

	@Override
	public boolean checkGame(String game) {
		Session session = sessionFactory.getCurrentSession();
		Query query;
		query = session.createQuery("from Game where game = :game");
		query.setParameter("game", game);
		return query.list().isEmpty();
	}
}
