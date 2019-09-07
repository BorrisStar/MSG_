package mygames.controller;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
		extends ResponseEntityExceptionHandler {

	// Инициализация логгера
	private static final Logger log = Logger.getLogger(RestResponseEntityExceptionHandler.class);
	{
		log.info("RestResponseEntityExceptionHandler OK");
	}

	/*public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView
	defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it - like the OrderNotFoundException example
		// at the start of this post.
		// AnnotationUtils is a Spring Framework utility class.
		if (AnnotationUtils.findAnnotation
				(e.getClass(), ResponseStatus.class) != null)
			throw e;

		// Otherwise setup and send the user to a default error-view.
		ModelAndView mav = new ModelAndView();
		mav.addObject("errorCode", ResponseStatus.class.toString());
		mav.addObject(" message", e);
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}*/



	@ExceptionHandler({ HttpClientErrorException.class,Throwable.class  })
	@ResponseStatus
	public String handleError4xx(HttpServletRequest request, Exception e) {
		log.info("4xx status");
		return "4xx error";
	}

	@ExceptionHandler(HttpServerErrorException.class)
	@ResponseStatus
	public String handleError5xx(HttpServletRequest request, Exception e) {
		log.info("5xx status");
		return "5xx error";
	}


	@ExceptionHandler//NoHandlerFound
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	protected String handle404Exception(HttpServletRequest request, Exception e) {
		log.info("404 status");
		return "error";//"There is no this page, sorry :-(";
	}

}