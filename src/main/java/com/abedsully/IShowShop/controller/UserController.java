package com.abedsully.IShowShop.controller;

import com.abedsully.IShowShop.exceptions.AlreadyExistException;
import com.abedsully.IShowShop.model.User;
import com.abedsully.IShowShop.request.CreateUserRequest;
import com.abedsully.IShowShop.request.UpdateUserRequest;
import com.abedsully.IShowShop.response.ApiResponse;
import com.abedsully.IShowShop.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    private final IUserService userService;

    @GetMapping("{id}")
    public ResponseEntity<ApiResponse> getUserById(Long id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(new ApiResponse("Success", user));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }

    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserRequest req) {
        try {
            User user = userService.createUser(req);
            return ResponseEntity.ok(new ApiResponse("Create User Success!", user));
        } catch (AlreadyExistException e) {
            return ResponseEntity.status(CONFLICT).body(new ApiResponse("An error occured:", e.getMessage()));
        }
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody UpdateUserRequest req, @PathVariable Long userId) {
        try {
            User user = userService.updateUser(req, userId);
            return ResponseEntity.ok(new ApiResponse("User updated successfully", user));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("An error occured: ", e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long userId) {
        try {
            userService.deleteUser(userId);
            return ResponseEntity.ok(new ApiResponse("User deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("An error occured", e.getMessage()));
        }

    }
}