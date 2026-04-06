package com.FinDashboard.repository;

import com.FinDashboard.entity.Transaction;
import com.FinDashboard.entity.User;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Transactionrepo extends JpaRepository<Transaction,Long> {
List<Transaction> findByuserId(Long userId);

}
