package br.com.btsoftware.repository;

import br.com.btsoftware.domain.User;
import br.com.btsoftware.domain.enums.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {

    @Query("SELECT u FROM users u WHERE email=?1 AND password=?2")
    public Optional<User> login(String email, String password);
    
    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE users SET role = ?2 WHERE id = ?1")
    public int updateRole(Long id, Role role);
}
