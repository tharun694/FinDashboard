package com.FinDashboard.controller;

import com.FinDashboard.entity.User;
import com.FinDashboard.enums.Role;
import com.FinDashboard.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {
    UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity<?> handle(RuntimeException exception) {
            return ResponseEntity.status(403).body(
                    Map.of("Error", exception.getMessage())
            );
        }
    }

    @PostMapping("/user")
    public ResponseEntity<?> addusers(@RequestBody User user) {
        User saveduser = userService.addusers(user);
        return ResponseEntity.ok(saveduser);
    }

//    @GetMapping("/{user_id}")
//public ResponseEntity<?>getuser(@PathVariable Long user_id){
//        User savedUser=userService.getuser(user_id);
//        return ResponseEntity.ok(savedUser);
//    }
}
