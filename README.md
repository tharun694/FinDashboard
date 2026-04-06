🚀 FinDashboard API

A role-based financial dashboard backend built using Spring Boot, providing transaction management, financial insights, and analytics.

---

🎨 Tech Stack & Docs

""Java" (https://img.shields.io/badge/Java-17-orange)" (https://www.oracle.com/java/)
""Spring Boot" (https://img.shields.io/badge/SpringBoot-Framework-green)" (https://spring.io/projects/spring-boot)
""Spring Data JPA" (https://img.shields.io/badge/SpringData-JPA-blue)" (https://spring.io/projects/spring-data-jpa)
""Hibernate" (https://img.shields.io/badge/Hibernate-ORM-yellow)" (https://hibernate.org/)
""MySQL" (https://img.shields.io/badge/MySQL-Database-blue)" (https://www.mysql.com/)
""Docker" (https://img.shields.io/badge/Docker-Container-blue)" (https://docs.docker.com/)
""Render" (https://img.shields.io/badge/Render-Deployment-purple)" (https://render.com/docs)
""Postman" (https://img.shields.io/badge/Postman-API_Testing-orange)" (https://www.postman.com/)

---

🌐 Live Project

👉 https://findashboard-3.onrender.com/

---

📌 Overview

FinDashboard is a backend system that manages financial transactions with Role-Based Access Control (RBAC) and provides real-time analytics such as summaries, monthly reports, and category-based insights.

---

🎯 Features

- 🔐 Role-Based Access Control (ADMIN, ANALYST, VIEWER)
- 💰 Transaction Management (Create, View, Delete)
- 📊 Financial Summary (Income, Expense, Balance)
- 📅 Monthly Summary
- 📈 Category-wise Analysis
- ⚠️ Global Exception Handling
- ☁️ Cloud Deployment (Render)
- 🐳 Dockerized Application

---

🧠 Roles & Permissions

Role| Access
ADMIN| Full control (CRUD + Summary + Analysis)
ANALYST| View all data + Summary + Analysis
VIEWER| View only own transactions

---

⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (Cloud Database)
- Maven
- Docker
- Render

---

📂 Project Structure

controller/
  - TransactionController
  - UserController

service/
  - TransactionService
  - UserService

entity/
  - User
  - Transaction

repository/
  - JPA Repositories

enums/
  - Role

---

🔗 API Endpoints

🔹 Health

GET /greet

🔹 User

POST /user

🔹 Transactions

PUT    /transaction/{adminId}
GET    /transactions/{userId}
DELETE /transaction/{userId}/{transId}

🔹 Summary & Analytics

GET /summary/{adminId}/{userId}
GET /summary/monthly/{adminId}/{userId}
GET /analysis/category/{adminId}/{userId}

---

📊 Sample Response

{
  "message": "Summary fetched",
  "data": {
    "income": 5000,
    "expense": 2000,
    "balance": 3000
  }
}

---

🐳 Docker Setup

mvn clean package
docker build -t findashboard .
docker run -p 8080:8080 findashboard

---

☁️ Deployment

- Deployed on Render
- Connected to Cloud MySQL Database
- Environment-based configuration

---

📚 Spring Boot Concepts Used

- REST Controllers ("@RestController")
- Dependency Injection
- Service Layer Architecture
- Spring Data JPA (Repositories)
- Entity Mapping ("@Entity")
- Exception Handling ("@RestControllerAdvice")
- Response Handling ("ResponseEntity")
- Aggregation Logic (Summary & Analysis)

---

🚀 Highlights

- Clean layered architecture
- Role-based authorization system
- Financial analytics implementation
- Production-style API responses
- Fully deployed live backend

---

🔮 Future Improvements

- JWT Authentication
- Pagination & Filtering
- DTO Layer
- Logging

---

👨‍💻 Author

Tharun Prakash
Backend Developer (Java | Spring Boot)

---

⭐ Final Note

This project demonstrates:

- Backend API design
- Role-based system implementation
- Data aggregation & analytics
- Cloud deployment

---
