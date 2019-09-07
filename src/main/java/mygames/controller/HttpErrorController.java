package mygames.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/*
400 - Bad Request
401 - Unauthorized
402 - Payment Required
403 - Forbidden
404 - Not Found
405 - Method Not Allowed
406 - Not Acceptable
407 - Proxy Authentication Required
408 - Request Time-out
409 - Conflict
410 - Gone
411 - Length Required
412 - Precondition Failed
413 - Request Entity Too Large
414 - Request-URI Too Large
415 - Unsupported Media Type
416 - Requested range not satisfiable
417 - Expectation Failed
500 - Internal Server Error
501 - Not Implemented
502 - Bad Gateway
503 - Service Unavailable
504 - Gateway Time-out
505 - HTTP Version not supported
 */


@Controller
public class HttpErrorController {
	private static final String GENERAL_ERROR_VIEW = "/error/general";

	@RequestMapping(value = "/errors/400.html")
	public ModelAndView handle400(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "400");
		modelAndView.addObject("message", "Error 400 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/404.html")
	public ModelAndView handle404(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "404");
		modelAndView.addObject("message", "Error 404 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/405.html")
	public ModelAndView handle405(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "405");
		modelAndView.addObject("message", "Error 405 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/406.html")
	public ModelAndView handle406(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "406");
		modelAndView.addObject("message", "Error 406 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/408.html")
	public ModelAndView handle408(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "408");
		modelAndView.addObject("message", "Error 408 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/415.html")
	public ModelAndView handle415(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "415");
		modelAndView.addObject("message", "Error 415 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/500.html")
	public ModelAndView handle500(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "500");
		modelAndView.addObject("message", "Error 500 happens");

		return modelAndView;
	}

	@RequestMapping(value = "/errors/503.html")
	public ModelAndView handle503(Model model) {

		ModelAndView modelAndView = new ModelAndView(GENERAL_ERROR_VIEW);
		modelAndView.addObject("errorCode", "503");
		modelAndView.addObject("message", "Error 503 happens");

		return modelAndView;
	}

}
