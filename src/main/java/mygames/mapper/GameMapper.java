package mygames.mapper;

import mygames.dto.GameDto;
import mygames.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GameMapper {
	static GameMapper getInstance() {
		return Mappers.getMapper(GameMapper.class);
	}
	Game gameDtoToGame(GameDto gameDto);
	GameDto gameToGameDto (Game game);
}
