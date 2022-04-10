package fr.coucou.zoomup.repository;

import fr.coucou.zoomup.domain._User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<_User, Integer> {

    Optional<_User> findByUsername(String username);

    Optional<_User> findByToken(String token);
}
