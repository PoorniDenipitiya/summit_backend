package com.foodie.psb_user.serviceImpl;

import com.foodie.psb_user.model.User;
import com.foodie.psb_user.repository.UserRepository;
import com.foodie.psb_user.service.UserService;
import com.foodie.psb_user.dto.SignUpRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        logger.debug("Fetching all users");
        List<User> users = userRepository.findAll();
        logger.debug("Found {} users", users.size());
        return users;
    }

    @Override
    public User getUserByEmail(String email) {
        logger.debug("Fetching user with email: {}", email);
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User createUser(SignUpRequest signUpRequest) {
        logger.debug("Creating new user with email: {}", signUpRequest.getEmail());
        User newUser = new User();
        newUser.setEmail(signUpRequest.getEmail());
        // Note: We're not storing the password in our database
        // The actual authentication will be handled by AWS Cognito
        User savedUser = userRepository.save(newUser);
        logger.debug("Created user: {}", savedUser);
        return savedUser;
    }

    @Override
    public User updateUser(String email, User user) {
        logger.debug("Updating user with email: {}", email);
        User existingUser = getUserByEmail(email);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            User updatedUser = userRepository.save(existingUser);
            logger.debug("Updated user: {}", updatedUser);
            return updatedUser;
        }
        logger.warn("User not found with email: {}", email);
        return null;
    }

    @Override
    public void deleteUser(String email) {
        logger.debug("Deleting user with email: {}", email);
        User user = getUserByEmail(email);
        if (user != null) {
            userRepository.delete(user);
            logger.debug("Deleted user with email: {}", email);
        } else {
            logger.warn("User not found with email: {}", email);
        }
    }
}