# UniAccounts – University Student Account Management System

## 1. Project Description

UniAccounts is a Java application designed to manage university student accounts.

The system allows users to create, manage, suspend, activate, and close student accounts. It also supports importing students from a legacy system and exporting account information in different formats.

## 2. Technologies Used

- Java
- Object-Oriented Programming
- Design Patterns
- Visual Studio Code

## 3. Design Patterns Used

### Creational Patterns
- **Builder:** Builds student accounts with required and optional information.
- **Singleton:** Ensures a single instance of AccountRepository and AuditLogger.
- **Prototype:** Creates new student accounts by cloning an existing template.

### Structural Patterns
- **Composite:** Organizes the university structure into faculties, departments, groups, and students.
- **Adapter:** Imports student records from the legacy system.
- **Decorator:** Adds optional services such as Library, Cafeteria, and Internet.
- **Facade:** Provides a simple interface to access the system.

### Behavioral Patterns
- **State:** Manages account states: PENDING, ACTIVE, SUSPENDED, and CLOSED.
- **Observer:** Notifies different components when account events occur.
- **Strategy:** Exports student accounts in CSV and JSON formats.

## 4. Project Structure

```text
UniAccounts/
│
├── Main.java
├── README.md
├── src/
│   ├── model/
│   └── patterns/
│
└── docs/
    └── UML.md
```

## 5. How to Compile and Run

Open the project folder in the terminal and execute:

```bash
javac -d . Main.java src/model/*.java src/patterns/*.java
```

Then run the application:

```bash
java Main
```

## 6. Main Features

- Create student accounts.
- Activate, suspend, and close accounts.
- Check student login permissions.
- Organize students using a university hierarchy.
- Import students from a legacy system.
- Export accounts to CSV and JSON.
- Add optional student services.
- Record account events and notify observers.

## 7. Documentation

The UML class diagram is available in the `docs` folder.

## 8. Conclusion

The UniAccounts project demonstrates the practical use of several software design patterns in a university student account management system.