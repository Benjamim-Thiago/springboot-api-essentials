package br.com.btsoftware.service;

import br.com.btsoftware.domain.User;
import br.com.btsoftware.repository.UserRepository;
import br.com.btsoftware.service.util.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        user.setId(null);
        user.setPassword(HashUtil.getSecureHash(user.getPassword()));
        User createdUser = userRepository.save(user);
        return createdUser;
    }

    public User update(User user) {
        user.setPassword(HashUtil.getSecureHash(user.getPassword()));
        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    public User getById(Long id) {
        Optional<User> result =  userRepository.findById(id);
        return result.get();
    }

    public List<User> listAll() {
        List<User> users = userRepository.findAll();

        return users;
    }

    public User login(String email, String password){
        password = HashUtil.getSecureHash(password);
        Optional<User> result =  userRepository.login(email, password);
        return result.get();
    }
}
