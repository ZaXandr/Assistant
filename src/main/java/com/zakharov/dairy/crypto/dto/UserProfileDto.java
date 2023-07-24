package com.zakharov.dairy.crypto.dto;

import com.zakharov.dairy.crypto.entity.Deal;

import java.util.List;

public class UserProfileDto {
    private Long id;
    private String name;
    private String email;
    private List<Deal> deals;
}
