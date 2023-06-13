package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.entity.UserEntity;
import org.example.model.User;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(value = "http://localhost:3000")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/{id}")
    public UserEntity userInfo(@PathVariable Long id, Model model){
        return userService.getUserById(id);
    }

    @GetMapping("/all")
    public List<UserEntity> allData(){
        return userService.getAllList();
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user){
        System.out.println(user);
        userService.saveUser(user);
        return "Book add";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        userService.deleteUser(id);
        return "New user is deleted";
    }

}
