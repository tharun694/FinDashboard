package com.FinDashboard.entity;

import com.FinDashboard.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
Long id;
String name;
String email;
Boolean isActive;
@Enumerated(EnumType.STRING)
Role role;

}
