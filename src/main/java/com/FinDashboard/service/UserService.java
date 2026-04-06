package com.FinDashboard.service;

import com.FinDashboard.entity.User;
import com.FinDashboard.enums.Role;
import com.FinDashboard.repository.UserRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {
    UserRepo repo;

    UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User addusers(User user) {
          return  repo.save(user);
        }


//    public User getuser(Long user_id) {
//       return  repo.findById(user_id).orElseThrow(()->new RuntimeException("user not found"));
//    }
}