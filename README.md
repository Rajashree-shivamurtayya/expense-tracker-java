# Expense Tracker CLI (Java + JDBC + MySQL)

A **command-line based Expense Tracker application** developed using **Core Java**, **JDBC**, and **MySQL**. This project helps users record, view, and manage daily expenses in a structured way using a relational database.

---

## 📌 Features

* Add new expenses
* View all expenses
* View expenses by category
* Delete an expense
* Persistent storage using MySQL
* Simple menu-driven CLI interface

---

## 🛠️ Technologies Used

* **Language:** Java (Core Java)
* **Database:** MySQL
* **Database Connectivity:** JDBC
* **IDE:** Eclipse
* **Version Control:** Git & GitHub

---

## 📂 Project Structure

```
ExpenseTracker/
│── src/
│   └── expensestracker/
│       ├── DBConnection.java
│       ├── Expense.java
│       ├── ExpenseDAO.java
│       └── ExpenseTrackerApp.java
│── .gitignore
│── README.md
```

---

## 📘 Module Description

### 1. DBConnection.java

* Establishes a connection between Java application and MySQL database using JDBC.
* Contains database URL, username, and password.

### 2. Expense.java

* Model (POJO) class representing an expense.
* Fields include:

  * `id`
  * `amount`
  * `category`
  * `description`
  * `date`

### 3. ExpenseDAO.java

* Data Access Object (DAO) class.
* Handles all database operations such as:

  * Insert expense
  * Fetch expenses
  * Delete expense

### 4. ExpenseTrackerApp.java

* Main class of the application.
* Provides a menu-driven command-line interface.
* Takes user input and calls DAO methods.

---

## 🗄️ Database Design

### Database Name

```
expense_tracker
```

### Table Structure

```sql
CREATE TABLE expenses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    amount DOUBLE NOT NULL,
    category VARCHAR(50),
    description VARCHAR(255),
    expense_date DATE
);
```

---

## ▶️ How to Run the Project

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/expense-tracker-java.git
```

### Step 2: Import into Eclipse

* Open Eclipse
* File → Import → Existing Projects into Workspace
* Select the project folder

### Step 3: Configure MySQL

* Create database and table using the SQL provided above
* Update credentials in `DBConnection.java`

### Step 4: Add MySQL Connector

* Download MySQL Connector/J
* Add it to project Build Path

### Step 5: Run the Application

* Run `ExpenseTrackerApp.java`
* Use the menu options in the console

---

## 📌 Sample Menu Output

```
1. Add Expense
2. View All Expenses
3. View Expenses by Category
4. Delete Expense
5. Exit
```

---

## 🎯 Learning Outcomes

* Hands-on experience with JDBC
* Understanding DAO design pattern
* MySQL database integration
* CLI-based application design
* Git and GitHub usage

---

## 🚀 Future Enhancements

* Monthly expense summary
* User authentication
* Export data to CSV
* Web or Spring Boot version

---

## 👤 Author

**Rajashree Shivamurtayya Ganganahalli**




