package com.springDataJpaMapping.Mapping.controller;

import com.springDataJpaMapping.Mapping.DTO.LoginDTO;
import com.springDataJpaMapping.Mapping.DTO.SignUpDTO;
import com.springDataJpaMapping.Mapping.DTO.UserDTO;
import com.springDataJpaMapping.Mapping.service.LoginService;
import com.springDataJpaMapping.Mapping.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {
    private final UserService userService;
    private final LoginService loginService;

    public AuthController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }
    @PostMapping("/signup")
    public ResponseEntity<UserDTO> userSignUp(@RequestBody  SignUpDTO signUpDTO){
        UserDTO user = userService.signUp(signUpDTO);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody LoginDTO loginDTO){
        String token = loginService.login(loginDTO);
        System.out.println(token);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }
}
