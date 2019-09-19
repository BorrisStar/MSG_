import mygames.config.ApplicationConfiguration;
import mygames.controller.GameController;
import mygames.dao.GameDAOImpl;
import mygames.model.Game;
import mygames.service.GameService;
import mygames.service.GameServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes =	{ApplicationConfiguration.class })
@Ignore
public class GameControllerTest {



	//@Mock
	//private Game game;
	private Game game;

	@Mock
	private GameServiceImpl gameServiceImpl;

	@Mock
	private GameDAOImpl gameDAOImpl;

	@InjectMocks
	private GameController gameController;

	@Mock
	private GameController gameControllerMock;

	MockMvc mockMvc;
	final GameController gameControllerMockMVC  = new GameController();

	@Before
	public void init(){
		 game = Mockito.mock(Game.class);

		mockMvc	 = MockMvcBuilders.standaloneSetup(gameControllerMockMVC).build();
	}



//	private MockMvc mockMvc;
//	private final HomeController controller = new HomeController();
//
//	@Before
//	public void setUp() {
//		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//	}
//
//	@Test
//	public void testIndex() throws Exception {
//		mockMvc.perform(get("/home"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("index")) // проверка имени view, котрый вернул action
//				.andExpect(model().attribute("foo", "bar")); // проверка атрибута модели
//	}


//		modelAndView.setViewName("editPage");
//		modelAndView.addObject("message", "Add new game!");
//		modelAndView.setStatus(HttpStatus.OK);
//		return modelAndView;

	//@WebAppConfiguration
	//@ContextConfiguration(classes = ApplicationConfig.class,loader = AnnotationConfigWebContextLoader.class)
	//@TransactionConfiguration(defaultRollback = true)
	//@Transactional
	//public class JUnitTests {
	//
	//  @Autowired
	//  private WebApplicationContext wac;
	//
	//  private MockMvc mockMvc;
	//
	//   @Before
	//   public void SetupContext()
	//   {
	//     this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	//   }


	
////  создаем POST-запрос, набиваем его параметрами и выполняем
//		mockMvc.perform(MockMvcRequestBuilders.post("/add")
//				.param("firstname",'firstname')
//				.param("lastname",'lastname')
//				.param("email",'firstname.lastname@gmail.com')
//				.param("telephone",'555-1234')
//				.param("contacttype.id", contactTypes[0].id.toString())
//		.andExpect(MockMvcResultMatchers.redirectedUrl("/index"))


	
	@Test
	public void addGameControllerTest() {

		try {
			mockMvc.perform(MockMvcRequestBuilders.post("/add"))
			.andExpect(view().name("editPage"))
			.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@org.junit.Test
	public void homeGameControllerTest() {
		try {
			mockMvc.perform(get("/"))
					.andExpect(view().name("games"))
					.andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@org.junit.Test
	public void gameTest() {
		//assertEquals(Game.class,game.getClass());

		//List<String> data = new ArrayList<>();
		//data.add("dataItem");
		//Mockito.doReturn(data).when(dataService).getData()

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("test");

		Mockito.when(gameControllerMock.allGames(1,HttpStatus.OK)).thenReturn(modelAndView);
		assertEquals(modelAndView,gameControllerMock.allGames(1,HttpStatus.OK));

		Mockito.doReturn(modelAndView).when(gameControllerMock).allGames(1,HttpStatus.OK);
		assertEquals(modelAndView,gameControllerMock.allGames(1,HttpStatus.OK));
	}

	@org.junit.Test
	public void setGameService() {

	}

	@org.junit.Test
	public void allGames() {

		ModelAndView modelAndView = gameController.allGames(1, HttpStatus.OK);
		assertEquals("ModelAndView [view=\"games\"; model={page=1, gamesList=[], gamesCount=0, pagesCount=0}]", modelAndView.toString());

	}

	@org.junit.Test
	public void addPage() {
		ModelAndView modelAndView = gameController.addPage("Add new game!");
		assertEquals("editPage", modelAndView.getViewName());
		assertEquals(HttpStatus.OK, modelAndView.getStatus());

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