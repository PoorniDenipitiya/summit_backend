package com.foodie.psb_user.service;

import com.foodie.psb_user.model.User;
import com.foodie.psb_user.dto.SignUpRequest;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserByEmail(String email);
    User createUser(SignUpRequest signUpRequest);
    User updateUser(String email, User user);
    void deleteUser(String email);
}