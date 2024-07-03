package com.pitang.car_user_management_api.service.impl;

import com.pitang.car_user_management_api.entity.User;
import com.pitang.car_user_management_api.repository.UserRepository;
import com.pitang.car_user_management_api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }


    @Override
    public User findById(Long id) {
        // Buscar Cliente por ID.
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) {
        Optional<User> userBd = userRepository.findById(id);
        if (userBd.isPresent()) {
            createUser(user);
        }
    }

    @Override
    public void removeUser(Long id) {

        userRepository.deleteById(id);
    }


}
