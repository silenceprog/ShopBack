package org.example.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.UserEntity;
import org.example.model.User;
import org.example.repos.UserRepos;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepos userRepos;

    @Override
    public List<UserEntity> getAllList() {
        List<UserEntity> userEntities = userRepos.findAll();
        return userEntities;
    }

    @Override
    public UserEntity saveUser(User user){
        UserEntity userEntity = UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
        log.info("Saving new{}", userEntity);
        userRepos.save(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity getUserById(Long id){
        return userRepos.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id){
        userRepos.deleteById(id);
    }
}
