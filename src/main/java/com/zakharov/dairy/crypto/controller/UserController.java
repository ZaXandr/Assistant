package com.zakharov.dairy.crypto.controller;

import com.zakharov.dairy.crypto.dto.UserPageDto;
import com.zakharov.dairy.crypto.entity.User;
import com.zakharov.dairy.crypto.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assistant/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.getALLUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id){
        userService.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
