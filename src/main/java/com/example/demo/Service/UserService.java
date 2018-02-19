package com.example.demo.Service;


import com.example.demo.Models.User;
import com.example.demo.Repositories.RoleRepository;
import com.example.demo.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


    public void saveApplicant(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("APPLICANT")));
        user.setEnabled(true);
        userRepository.save(user);
    }

    public void saveEmplpyer(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("EMPLOYER")));
        user.setEnabled(true);
        userRepository.save(user);
    }




}