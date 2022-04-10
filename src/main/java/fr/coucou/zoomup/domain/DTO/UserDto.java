package fr.coucou.zoomup.domain.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private String token;
    private List<CategoryDto> followed;
}
