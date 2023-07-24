package com.zakharov.dairy.crypto.service;

import com.zakharov.dairy.crypto.entity.Deal;
import com.zakharov.dairy.crypto.entity.User;
import com.zakharov.dairy.crypto.exception.UserNotFoundException;
import com.zakharov.dairy.crypto.repository.DealRepository;
import com.zakharov.dairy.crypto.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {

    private final DealRepository dealRepository;
    private final UserRepository userRepository;

    public DealService(DealRepository dealRepository, UserRepository userRepository) {
        this.dealRepository = dealRepository;
        this.userRepository = userRepository;
    }

    public List<Deal> getAllDeals(Long userId) {
        return dealRepository.getAllDealsByOwnerId(userId);
    }

    public Deal addDeal(Long userId, Deal deal){

        User owner = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException(userId));
        deal.setOwner(owner);
        return dealRepository.save(deal);
    }
}
