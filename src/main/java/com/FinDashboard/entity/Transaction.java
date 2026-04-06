package com.FinDashboard.entity;

import com.FinDashboard.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private   double amount;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String category;
    private  LocalDate date;
    private String description;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
