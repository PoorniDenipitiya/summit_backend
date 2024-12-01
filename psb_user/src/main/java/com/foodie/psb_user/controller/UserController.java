package com.foodie.psb_user.controller;

import com.foodie.psb_user.model.User;
import com.foodie.psb_user.service.UserService;
import com.foodie.psb_user.dto.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
        return createSuccessResponse(userService.getAllUsers(), "All users retrieved successfully.");
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse<User>> getUserByEmail(@PathVariable String email) {
        User user = userService.getUserByEmail(email);
        if (user == null) {
            return createNotFoundResponse("User with email " + email + " not found.");
        }
        return createSuccessResponse(user, "User retrieved successfully.");
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<User>> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        User newUser = userService.createUser(signUpRequest);
        return createCreatedResponse(newUser, "User created successfully.");
    }

    @PutMapping("/{email}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable String email, @RequestBody User user) {
        User updatedUser = userService.updateUser(email, user);
        if (updatedUser == null) {
            return createNotFoundResponse("User with email " + email + " not found.");
        }
        return createSuccessResponse(updatedUser, "User updated successfully.");
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return createSuccessResponse(null, "User deleted successfully.");
    }
}