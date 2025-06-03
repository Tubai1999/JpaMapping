package com.springDataJpaMapping.Mapping.service;

import com.springDataJpaMapping.Mapping.DTO.LoginDTO;
import com.springDataJpaMapping.Mapping.DTO.SignUpDTO;
import com.springDataJpaMapping.Mapping.DTO.UserDTO;
import com.springDataJpaMapping.Mapping.Entities.User;
import com.springDataJpaMapping.Mapping.exception.ResourceNotFoundException;
import com.springDataJpaMapping.Mapping.repositories.UserRepository;
import org.modelmapper.ModelMapper;
//import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public UserService(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(()->{
           return new  ResourceNotFoundException("Data not found");
        });
    }

    public UserDTO signUp(SignUpDTO signUpDTO){
        Optional<User> user = userRepository.findByEmail(signUpDTO.getEmail());
        if(user.isPresent()){
            throw new ResourceNotFoundException("email is already present");
        }
       User convertedUser =  modelMapper.map(signUpDTO,User.class);
        System.out.println(convertedUser);
        convertedUser.setPassword(bCryptPasswordEncoder.encode(convertedUser
                .getPassword()));
        userRepository.save(convertedUser);
        UserDTO userDTO =  modelMapper.map(convertedUser,UserDTO.class);
        System.out.println(userDTO);
        return userDTO;
    }

//    public String login(LoginDTO loginDTO) {
////
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginDTO.getEmail(),loginDTO.getPassword())
//        );
//        User user = (User) authentication.getPrincipal();
//        return jwtService.generateToken(user);
//    }
}
