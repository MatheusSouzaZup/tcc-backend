package com.TCC.TCC.service;

import com.TCC.TCC.BusinessExceptions.Exceptions;
import com.TCC.TCC.model.User;
import com.TCC.TCC.repository.UserRepository;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User Save(User user) throws Exception {
        User sameUsername = this.userRepository.findByUsernameEquals(user.getUsername());
        if(sameUsername != null && sameUsername.getId().equals(user.getId())) {
            throw Exceptions.SameValue("username", user.getUsername());
        }

        //

        User sameEmail = this.userRepository.findByEmailEquals(user.getEmail());
        if(sameUsername != null && sameUsername.getId().equals(user.getId())) {
            throw Exceptions.SameValue("email", user.getEmail());
        }

        User result = this.userRepository.save(user);
        return result;
    }

    @Transactional
    public User Create(User user) {
        user.setId(null);

        return this.Save(user);
    }

    @Transactional
    public User Update(Long id, User user) throws Exception {
        user.setId(id);

        return this.Save(user);
    }

    @Transactional
    public User Delete(Long id){ return null; }

    public User Find(Long id) {
        return null;
    }

    public List<User> Find() {
        return null;
    }
}
