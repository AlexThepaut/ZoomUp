package fr.coucou.zoomup.domain.mapper;

import fr.coucou.zoomup.domain.DTO.UserDto;
import fr.coucou.zoomup.domain._User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDto toDto(_User user);
    _User toEntity(UserDto user);
}
