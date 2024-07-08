package com.pitang.car_user_management_api.service.impl;

import com.pitang.car_user_management_api.entity.User;
import com.pitang.car_user_management_api.exception.FieldExistException;
import com.pitang.car_user_management_api.exception.UserNotFoundException;
import com.pitang.car_user_management_api.handlers.ErrorMessage;
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
    public void createUser(User user) throws FieldExistException {
        validateUserFields(user);

        userRepository.save(user);
    }

    @Override
    public void updateUser(Long id, User user) throws FieldExistException {
        Optional<User> userBd = userRepository.findById(id);

        validateUserFieldsUpdate(user, userBd);
        if (userBd.isPresent()) {
            user.setId(id);
            userRepository.save(user);
        }
    }

    @Override
    public void removeUser(Long id) throws UserNotFoundException{
        Optional<User> user = this.userRepository.findById(id);
        if (user.isPresent()) {

            User userOptional = user.get();

            // Delete the user
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException(new ErrorMessage(0, "User not found"));
        }
    }

    public void validateUserFields(User user) throws FieldExistException {
        // Verificar se o email já existe
        if (this.userRepository.existsByEmail(user.getEmail())) {
            throw new FieldExistException(new ErrorMessage(2, "Email already exists"));
        }
        // Verificar se o login já existe
        if (this.userRepository.existsByLogin(user.getLogin())) {
            throw new FieldExistException(new ErrorMessage(3, "Login already exists"));
        }
        // Verificar campos vazios
        if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getPhone().isEmpty()) {
            throw new FieldExistException(new ErrorMessage(4, "Invalid fields"));
        }
        // Verificar campos nulos
        if(user.getFirstName() == null || user.getLastName() == null || user.getBirthday() == null || user.getPhone() == null) {
            throw new FieldExistException(new ErrorMessage(5, "Missing fields"));
        }
    }

    public void validateUserFieldsUpdate(User user, Optional<User> userDb) throws FieldExistException {
        // Verificar se o email já existe
        if(userDb.get().getEmail() != user.getEmail() && this.userRepository.existsByEmail(user.getEmail()))
            throw new FieldExistException(new ErrorMessage(2, "Email already exists"));
        // Verificar se o login já existe
        if(userDb.get().getLogin() != user.getLogin() && this.userRepository.existsByLogin(user.getLogin()))
            throw new FieldExistException(new ErrorMessage(3, "Login already exists"));
        // Verificar campos vazios
        if(user.getFirstName().isEmpty() || user.getLastName().isEmpty() || user.getPhone().isEmpty())
            throw new FieldExistException(new ErrorMessage(4, "Invalid fields"));
        // Verificar campos nulos
        if(user.getFirstName() == null || user.getLastName() == null || user.getBirthday() == null || user.getPhone() == null)
            throw new FieldExistException(new ErrorMessage(5, "Missing fields"));

    }

}
