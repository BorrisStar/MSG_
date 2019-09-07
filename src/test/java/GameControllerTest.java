import mygames.controller.GameController;
import mygames.dao.GameDAOImpl;
import mygames.model.Game;
import mygames.service.GameService;
import mygames.service.GameServiceImpl;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class GameControllerTest {


	@Mock
	private Game game;

	@Mock
	private GameServiceImpl gameServiceImpl;

	@Mock
	private GameDAOImpl gameDAOImpl;

	@InjectMocks
	private GameController gameController;


	@org.junit.Test
	public void setGameService() {

	}

	@org.junit.Test
	public void allGames() {

		ModelAndView modelAndView = gameController.allGames(1);
		assertEquals("ModelAndView [view=\"games\"; model={page=1, gamesList=[], gamesCount=0, pagesCount=0}]", modelAndView.toString());

	}

	@org.junit.Test
	public void addPage() {
	}

	@org.junit.Test
	public void addGame() {

		ModelAndView modelAndView = new ModelAndView();

	}

	@org.junit.Test
	public void editPage() {
	}

	@org.junit.Test
	public void editGame() {
	}

	@org.junit.Test
	public void deleteGame() {
	}
}