package com.zakharov.dairy.crypto.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class AuthenticationRequest {

    private String name;
    private String password;


}
