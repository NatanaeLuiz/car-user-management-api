package com.pitang.car_user_management_api.service;

import com.pitang.car_user_management_api.entity.User;

import java.util.List;

public interface UserService {
    
    List<User> findAllUsers();

    User findById(Long id);

    void createUser(User user);

    void updateUser(Long id, User user);

    void removeUser(Long id);
}
