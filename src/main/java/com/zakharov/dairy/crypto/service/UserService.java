package com.zakharov.dairy.crypto.service;

import com.zakharov.dairy.crypto.entity.User;
import com.zakharov.dairy.crypto.exception.UserNotFoundException;
import com.zakharov.dairy.crypto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getALLUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).
                orElseThrow(()->new UserNotFoundException(id));
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(user);
    }

    public void updateUser(Long id, User user) {
        User userForUpdate = userRepository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
        userForUpdate.setName(user.getName());
        userForUpdate.setEmail(user.getEmail());

        userRepository.save(userForUpdate);
    }
}
