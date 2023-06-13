package org.example.services;

import org.example.entity.UserEntity;
import org.example.model.User;

import java.util.List;

public interface UserService {

    public List<UserEntity> getAllList();

    public UserEntity saveUser(User user);

    public UserEntity getUserById(Long id);

    public void deleteUser(Long id);
}
