package com.ecommerceClone.userManagement.service;

import com.ecommerceClone.userManagement.entity.User;
import com.ecommerceClone.userManagement.repo.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    // Constructor injection is preferred over @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // registering new user
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setUserName(updatedUser.getUserName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setAddress(updatedUser.getAddress());
            return userRepository.save(user);
        }).orElseThrow(()->new RuntimeException("user not found"));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
