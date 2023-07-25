package com.zakharov.dairy.crypto.service;

import com.zakharov.dairy.crypto.dto.UserPageDto;
import com.zakharov.dairy.crypto.entity.User;
import com.zakharov.dairy.crypto.exception.UserNotFoundException;
import com.zakharov.dairy.crypto.mapper.UserMapper;
import com.zakharov.dairy.crypto.repository.DealRepository;
import com.zakharov.dairy.crypto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final DealRepository dealRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, DealRepository dealRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.dealRepository = dealRepository;
        this.userMapper = userMapper;
    }

    public List<User> getALLUsers() {
        return userRepository.findAll();
    }

    public UserPageDto getUserById(Long id) {
        UserPageDto user = userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new UserNotFoundException(id));

        user.setCount(dealRepository.countByOwnerId(id));
        user.setDeals(dealRepository.getAllDealsByOwnerId(id));

        return user;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).
                orElseThrow(() -> new UserNotFoundException(id));

        userRepository.delete(user);
    }

    public void updateUser(Long id, User user) {
        User userForUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        userForUpdate.setName(user.getName());
        userForUpdate.setEmail(user.getEmail());

        userRepository.save(userForUpdate);
    }
}
