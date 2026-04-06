🚀 Finance Dashboard Backend API

🔗 Live API: https://findashboard-3.onrender.com/
📦 GitHub Repository: <your-github-link>

---

📌 Overview

A robust backend system for a Finance Dashboard that manages financial transactions, user roles, and analytics.

This project demonstrates:

- Clean API design
- Role-based access control
- Aggregation logic (summary, monthly, category analysis)
- Real-world backend architecture

---

🧠 Roles & Access Control

Role| Permissions
Admin| Full CRUD on transactions, access all summaries
Analyst| View transactions + analytics
Viewer| View only own transactions

---

⚙️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL / Cloud DB
- REST API
- Docker
- Render (Deployment)

---

📂 Features

- User management with roles
- Transaction CRUD operations
- Summary APIs (income, expense, balance)
- Monthly aggregation
- Category-wise analysis
- Role-based authorization
- Global exception handling

---

📡 API Endpoints

---

🧪 Health Check

GET /greet

---

👤 User APIs

➤ Create User

POST /user

Request Body:

{
  "name": "Tharun",
  "email": "test@gmail.com",
  "role": "ADMIN"
}

---

💰 Transaction APIs

---

➤ Add Transaction (Admin only)

PUT /transaction/{adminId}

---

➤ Get Transactions by User

GET /transactions/{user_id}

---

➤ Delete Transaction

DELETE /{userId}/{transId}

---

➤ Get All Transactions (Optional)

GET /transactions

---

📊 Dashboard APIs

---

➤ Summary (Income, Expense, Balance)

GET /summary/{adminId}/{userId}

Response:

{
  "message": "Summary fetched",
  "data": {
    "income": 5000,
    "expense": 2000,
    "balance": 3000
  }
}

---

➤ Monthly Summary

GET /summary/monthly/{adminId}/{userId}

---

➤ Category Analysis

GET /analysis/category/{adminId}/{userId}

---

🔐 Access Control Logic

- Admin required for:
  
  - Add / Delete transactions
  - Summary & analytics

- Viewer:
  
  - Only read own transactions

- Analyst:
  
  - Access insights + summaries

---

⚠️ Error Handling

All errors return structured JSON:

{
  "status": 403,
  "error": "Forbidden",
  "message": "Access Denied"
}

---

🧠 Use Cases

---

 1. Admin creates transaction

- Admin adds financial records for users
- Data stored and linked to user

---

 2. Viewer checks own transactions

- Can only access their data
- No modification allowed

---

 3. Analyst views insights

- Category-wise spending
- Monthly trends
- Summary data

---

 4. Dashboard consumption

Frontend can directly use:

- "/summary" → balance
- "/monthly" → charts
- "/analysis" → pie charts

---

🗄️ Data Model

User

- id
- name
- email
- role

Transaction

- id
- amount
- type (INCOME / EXPENSE)
- category
- date
- user (relation)

---

🚀 Deployment

- Hosted on Render
- Dockerized application
- Cloud database integration

---

📈 Highlights

✔ Clean architecture
✔ Real-world backend logic
✔ Aggregation APIs
✔ Role-based system
✔ Production-like deployment

---

🔥 Future Improvements

- JWT Authentication
- Pagination
- Swagger API docs
- Unit testing

---

👨‍💻 Author

Tharun Prakash
Backend Developer

---

⭐ If you like this project, feel free to star the repo!
