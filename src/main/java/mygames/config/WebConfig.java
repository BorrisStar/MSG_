package mygames.config;



import mygames.exceptions.CustomSimpleMappingExceptionResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.ws.rs.InternalServerErrorException;
import java.util.Properties;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "mygames")
public class WebConfig implements WebMvcConfigurer {


	@Override

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/res/**").addResourceLocations("/res/");
	}

/*	@Bean
	HandlerExceptionResolver customExceptionResolver () {
		CustomSimpleMappingExceptionResolver resolver = new CustomSimpleMappingExceptionResolver();
		Properties mappings = new Properties();
		// Mapping Spring internal error NoHandlerFoundException to a view name
		mappings.setProperty(NoHandlerFoundException.class.getName(), "/error/404");
		mappings.setProperty(InternalServerErrorException.class.getName(), "/error/500");
		mappings.setProperty(NullPointerException.class.getName(), "/error/500");
		mappings.setProperty(ClassNotFoundException.class.getName(), "/error/500");
		mappings.setProperty(Exception.class.getName(), "/error/generic");
		resolver.setExceptionMappings(mappings);
		// Set specific HTTP codes
		resolver.addStatusCode("404", HttpStatus.NOT_FOUND.value());
		resolver.addStatusCode("500", HttpStatus.INTERNAL_SERVER_ERROR.value());
		resolver.setDefaultErrorView("/error/generic");
		resolver.setDefaultStatusCode(200);
		// This resolver will be processed before the default ones
		resolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
		resolver.setExceptionAttribute("exception");
		return resolver;
	}*/


//В методе viewResolver() мы создаем его реализацию и определяем где именно искать представления в webapp
	@Bean
	ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}


}
