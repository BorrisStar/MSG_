package mygames.controller;




import mygames.dto.GameDto;
import mygames.mapper.GameMapper;
import mygames.model.Game;

import mygames.validators.GameValidator;
import org.apache.log4j.Logger;

import mygames.service.GameService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RestController
public class GameController implements HandlerExceptionResolver {

	private int init;

	@PostConstruct
	public void init(){
		log.info("Phase 1");
		init = 100;
	}


	public GameController() {
		log.info("Phase 2");
		log.info("Constructor  " + init);//init  = 0
	}

	// Инициализация логгера
	private static final Logger log = Logger.getLogger(GameController.class);

	private static final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	static {
		messageSource.setBasename("message");
	}

	private GameValidator gameValidator;

	private GameMapper mapper = Mappers.getMapper(GameMapper.class);

	private int page;

	private GameService gameService;

	@Autowired
	public void setGameService(GameService gameService) {
		this.gameService = gameService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView allGames(@RequestParam(defaultValue = "1") int page) {

		log.info("@PostConstruct: " + init);

		log.info("Main page");

		List<Game> games = gameService.allGames(page);
		List<GameDto> gamesDto = new ArrayList<>();
		for (Game game:games) {
			gamesDto.add(mapper.gameToGameDto(game));
		}
		int gamesCount = gameService.gamesCount();
		int pagesCount = (gamesCount + 9)/10;
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("games");
		modelAndView.addObject("page", page);
		modelAndView.addObject("gamesList", gamesDto);
		modelAndView.addObject("gamesCount", gamesCount);
		modelAndView.addObject("pagesCount", pagesCount);
		this.page = page;

		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView addPage(@ModelAttribute("message") String message) {

		String stringInfo  = String.format("Edit page %s\" ",message);
		log.info(stringInfo);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editPage");
		return modelAndView;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addGame(  @ModelAttribute("game") @Valid GameDto gameDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			log.info("Есть ошибки ввода Game!");
		}

		Game game = mapper.gameDtoToGame(gameDto);

		String stringInfo  = String.format("Add game %s\" ",game.getGame());
		log.info(stringInfo);

		ModelAndView modelAndView = new ModelAndView();

		if (gameService.checkGame(game.getGame())) {
			modelAndView.setViewName("redirect:/");
			modelAndView.addObject("page", page);
			gameService.add(game);
		} else {
			modelAndView.addObject("message","part with game \"" + game.getGame() + "\" already exists");
			modelAndView.setViewName("redirect:/add");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editPage(@PathVariable("id") int id,
								 @ModelAttribute("message") String message) {

		String stringInfo  = String.format("Edit page id = %d message - %s ",id, message);
		log.info(stringInfo);

		Game game = gameService.getById(id);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("editPage");
		modelAndView.addObject("game", game);
		return modelAndView;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView editGame(@ModelAttribute("game") @Valid GameDto gameDto, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			log.info("Есть ошибки ввода Game!");
		}

		Game game = mapper.gameDtoToGame(gameDto);

		String stringInfo  = String.format("Edit Game %s ",game.getGame());
		log.info(stringInfo);

		ModelAndView modelAndView = new ModelAndView();
		if (gameService.checkGame(game.getGame()) || gameService.getById(game.getId()).getGame().equals(game.getGame())) {
			modelAndView.setViewName("redirect:/");
			modelAndView.addObject("page", page);
			gameService.edit(game);
		} else {
			modelAndView.addObject("message","part with game \"" + game.getGame() + "\" already exists");
			modelAndView.setViewName("redirect:/edit/" +  + game.getId());
		}
		return modelAndView;
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGame(@PathVariable("id") int id) {
		String stringInfo  = String.format("Delete id = %d ",id);
		log.info(stringInfo);
		ModelAndView modelAndView = new ModelAndView();
		int gamesCount = gameService.gamesCount();
		int page = ((gamesCount - 1) % 10 == 0 && gamesCount > 10 && this.page == (gamesCount + 9)/10) ?
				this.page - 1 : this.page;
		modelAndView.setViewName("redirect:/");
		modelAndView.addObject("page", page);
		Game game = gameService.getById(id);
		gameService.delete(game);
		return modelAndView;
	}



	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, Object handler, Exception ex) {
		System.out.println("controller local exception handling HandlerExceptionResolver");

		resp.reset();
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/json");

		ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
		if (ex instanceof RuntimeException){
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			model.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addObject("message", ex.getMessage());
		} else {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			model.addObject("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
			model.addObject("message", ex.getMessage());
		}
		return model;
	}
}
