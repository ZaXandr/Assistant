package com.zakharov.dairy.crypto.controller;

import com.zakharov.dairy.crypto.entity.Deal;
import com.zakharov.dairy.crypto.service.DealService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assistant/api/v1/users/{userId}/deals")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping
    public ResponseEntity getAllUsersDeals(@PathVariable Long userId){
            return ResponseEntity.status(HttpStatus.OK).body(dealService.getAllDeals(userId));
    }

    @PostMapping
    public ResponseEntity saveDealForUser(@PathVariable Long userId,  @RequestBody Deal deal){
        return ResponseEntity.status(HttpStatus.CREATED).body(dealService.addDeal(userId,deal));
    }
}
