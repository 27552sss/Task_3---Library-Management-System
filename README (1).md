# 📚 Library Management System (Java, CLI)

A simple command-line based Library Management System built in Java using Object-Oriented Programming (OOP) principles. - Task_3

## ✅ Features

- Load book data from a CSV file (`data.csv`)
- User registration (Student or Teacher) with dynamic ID
- Issue and return books
- Track books issued per user
- View issued books and user book summary

## 🚫 Removed Features

- ❌ View All Books option (replaced with minimal title-author output)

## 📂 Folder Structure

```
LibraryManagementSystem/
├── Book.java
├── User.java
├── Library.java
├── Main.java
├── data.csv
```

## 🛠 Tech Stack

- Java (JDK 8+)
- CLI / Terminal
- CSV for book data

## ▶️ How to Run

1. Make sure you have Java installed:
   ```sh
   java -version
   ```

2. Compile all `.java` files:
   ```sh
   javac *.java
   ```

3. Run the program:
   ```sh
   java Main
   ```

4. On startup, enter your name and whether you're a student or teacher.

## 📄 Book Data Format (data.csv)

The system reads book data from a kaggle CSV file  with the following format:

```
Title,Author
The Alchemist,Paulo Coelho
Sapiens,Yuval Noah Harari
Atomic Habits,James Clear
...
```

## 🧠 Concepts Demonstrated

- Inheritance (Student, Teacher from User)
- Abstraction and abstract classes
- Encapsulation (private fields + getters/setters)
- Polymorphism and dynamic method binding

## 📌 Note

This is a CLI-based learning project suitable for internships, OOP practice, or mini-projects.

---

Made with 💻 by [Priyansh Tyagi]
