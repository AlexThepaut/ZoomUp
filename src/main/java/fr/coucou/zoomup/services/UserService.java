package fr.coucou.zoomup.services;

import fr.coucou.zoomup.domain.DTO.UserDto;
import fr.coucou.zoomup.domain._User;
import fr.coucou.zoomup.domain.mapper.UserMapper;
import fr.coucou.zoomup.domain.mapper.UserMapperImpl;
import fr.coucou.zoomup.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    UserMapper userMapper = new UserMapperImpl();

    public String login(String username, String password) {
        log.info("Logging user {}", username);
        Optional<_User> userOpt = userRepository.findByUsername(username);
        if(userOpt.isEmpty()){
            // TODO Make better return form error handling in front
            return null;
        }

        if(!passwordEncoder.matches(password, userOpt.get().getPassword())) {
            // TODO Make better return form error handling in front
            return null;
        }

        String token = UUID.randomUUID().toString();
        _User user = userOpt.get();
        user.setToken(token);
        userRepository.save(user);
        return token;
    }

    public void logout(String username) {
        Optional<_User> userOpt = userRepository.findByUsername(username);

        if(userOpt.isEmpty()){
            // TODO Make better return form error handling in front
        }
        _User user = userOpt.get();
        user.setToken(null);
        userRepository.save(user);
    }

    public UserDto newUser(UserDto newUser) {
        newUser.setToken(UUID.randomUUID().toString());
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        _User user = userRepository.save(userMapper.toEntity(newUser));
        return userMapper.toDto(user);
    }

    public Optional<User> findByToken(String token) {
        Optional<_User> userOpt = userRepository.findByToken(token);
        if(userOpt.isPresent()){
            _User user = userOpt.get();
            User userDetails = new User(user.getUsername(), user.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(userDetails);
        }
        return Optional.empty();
    }
}
