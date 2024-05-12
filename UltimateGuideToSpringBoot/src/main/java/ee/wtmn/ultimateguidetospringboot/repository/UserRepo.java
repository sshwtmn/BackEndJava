package ee.wtmn.ultimateguidetospringboot.repository;

import ee.wtmn.ultimateguidetospringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
    Optional<User> findUserByEmail(String email);

}
