package br.com.btsoftware.repository;

import br.com.btsoftware.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u WHERE email=?1 AND password=?2")
    public Optional<User> login(String email, String password);
}
