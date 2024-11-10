package com.ecommerceClone.userManagement.service;

import com.ecommerceClone.userManagement.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User registerUser(User user);
    public Optional<User> getUserById(Long id);
    public List<User> getAllUsers();
    public User updateUser(Long id, User updatedUser);
    public void deleteUser(Long id);

}
