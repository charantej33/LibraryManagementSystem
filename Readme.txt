# 📚 Library Management System – Java Console Application

A simple object-oriented Library Management System built in Java using core OOP principles, SOLID design, and basic design patterns.

---

## 🔧 Features Implemented

- 📕 Book Management
  - Add, remove, search, and update books
  - Search by Title, Author, ISBN (Strategy Pattern)

- 👤 Patron Management
  - Register and update patrons
  - Track borrowing history per patron

- 📖 Lending Management
  - Lend and return books
  - Track status (available / borrowed)
  - Overdue check

- 🧠 Technical Design
  - Java Collections (`Map`, `List`)
  - Strategy Pattern for searching
  - Java Logging (`java.util.logging`)
  - Strong focus on OOP (Encapsulation, Abstraction, Polymorphism, Inheritance)

---

## 🚀 How to Run

### ✅ Prerequisites
- Java JDK 8+ installed
- Command line / terminal access

### 📦 Compile

```bash
javac *.java
------------------------------------------------------------------Text Based Flow Chart-----------------------------------------------------------------------------------------------------------
+-------------------+
|  Main.java        |
|-------------------|
| 1. Load books     |
| 2. Load patrons   |
| 3. Lend/return    |
| 4. Display data   |
+--------+----------+
         |
         v
+-------------------------+
| BookManagement.java     |
|-------------------------|
| Stores book info        |
| get/set title, status   |
+-------------------------+

         |
         v
+-------------------------+
| PatronSystem.java       |
|-------------------------|
| Stores patron info      |
| Records borrow history  |
+-------------------------+

         |
         v
+-------------------------+
| BookLendingRecord.java  |
|-------------------------|
| Book + Patron link      |
| Borrow/Return logic     |
+-------------------------+

         |
         v
+-------------------------------+
| Search Strategy Classes       |
|-------------------------------|
| Search by title, author, ISBN |
| (Strategy Pattern)            |
+-------------------------------+
-----------------------------------------------------------------------------File Structure------------------------------------------------------------------------------------------------------------
├── Main.java
├── BookManagement.java
├── BookStatus.java
├── BookLendingRecords.java
├── LibraryMaintinance.java
├── PatronSystem.java
├── BookSearchStreadgy.java
├── AuthorSearchStreadgy.java
├── TitleSearchStreadgy.java
├── IsbnSearchStreadgy.java
├── PatronSearchStreadgy.java
├── PatronSearchbyID.java
├── PatronSearchbyname.java