package fr.coucou.zoomup.api;

import fr.coucou.zoomup.domain.DTO.UserDto;
import fr.coucou.zoomup.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/authent")
public class AuthentResource {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody UserDto user) {
        return userService.login(user.getUsername(), user.getPassword());
    }

    @PostMapping("/logout")
    public void logout(@RequestBody UserDto user) {
        userService.logout(user.getUsername());
    }

    @PostMapping("/createUser")
    public UserDto newUser(UserDto newUser) {
        return userService.newUser(newUser);
    }
}
