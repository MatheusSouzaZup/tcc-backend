package com.TCC.TCC.repository;

import com.TCC.TCC.model.Function;
import com.TCC.TCC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsernameEquals(String username);
    public User findByEmailEquals(String email);
}
