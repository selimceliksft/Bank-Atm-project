ATM Management System

This project is an ATM (Automated Teller Machine) management system implemented in Java. It simulates the functionality of an ATM, allowing users to perform various banking transactions such as withdrawals, deposits, transfers, and inquiries.

Features
User Authentication: Users are required to enter a PIN to authenticate their identity.
Transaction Management: Supports various transactions including withdrawals, deposits, transfers, and inquiries.
Security: Implements security measures such as PIN verification and card retention for incorrect PIN attempts.
Database Interaction: Interacts with a database to retrieve account and transaction information.
Logging: Logs transaction details for auditing and debugging purposes.
Error Handling: Includes error handling mechanisms to handle invalid user inputs and system errors gracefully.

Prerequisites
Java Development Kit (JDK)
MySQL database (optional, for database interaction)

Getting Started
Clone the Repository: Clone this repository to your local machine ->  git clone https://github.com/your-username/atm-management-system.git
Compile the Code: Compile the Java files using a Java compiler -> javac com/model/*.java
Run the Application: Execute the main Java file to start the ATM management system -> java com.model.App

Usage
Upon running the application, the ATM system initializes and prompts the user to insert a card.
Users are prompted to enter their PIN for authentication.
After successful authentication, users can choose from various transaction options.
Follow the on-screen instructions to complete the desired transaction.
Upon completion, the user can eject their card.

Configuration (Database Connection)
If you intend to use the database interaction features of the ATM system, you'll need to configure the database connection settings. 
Modify the App.java file and uncomment the database connection code block. 
Update the url, username, and password variables with your database connection details.

// Connect to the database
String url = "jdbc:mysql://localhost:3306/atmDatabase";
String username = "root";
String password = "your_password";
Connection connection = DriverManager.getConnection(url, username, password);

