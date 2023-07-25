package com.zakharov.dairy.crypto.mapper;

import com.zakharov.dairy.crypto.dto.UserPageDto;
import com.zakharov.dairy.crypto.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserPageDto toDto(User user){
        UserPageDto pageDto = new UserPageDto();
        pageDto.setId(user.getId());
        pageDto.setName(user.getEmail());
        pageDto.setEmail(user.getEmail());
        return pageDto;
    }
}
