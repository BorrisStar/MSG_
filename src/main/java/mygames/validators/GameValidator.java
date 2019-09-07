package mygames.validators;

import mygames.dto.GameDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class GameValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return GameDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		GameDto gameDto = (GameDto) target;

		if (gameDto.getYear() < 0) {
			errors.rejectValue("Year", "value.negative");
		}
	}
}
