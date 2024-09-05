# Travel and Tourism Management System

## Project Overview
The **Travel and Tourism Management System** is a desktop application designed to manage various aspects of travel and tourism, including user registration, package booking, hotel management, and payment processing. It is built using **Java Swing** for the user interface and **MySQL** for database management. The project implements multi-threading to provide smooth animations and responsive UI elements such as progress bars and window transitions.

This project was developed as a major project for my college coursework, showcasing my skills in Java programming, database management, and application design.

## Dashboard Preview
Below is a screenshot of the application’s dashboard:

![Dashboard](https://github.com/monukd01dev/travel-and-tourism-management-system/blob/master/images/dashboard.png)

## Features

### Authentication and Account Management
- **Login**: Users can log in with their credentials. Upon successful login, they are redirected to the dashboard.
- **Signup**: New users can create an account by entering a username, name, password, and security question/answer. All fields are mandatory.
- **Forgot Password**: Users can retrieve their password by providing their username, answering a security question, and receiving the correct password if the answer is valid.

All forms are thoroughly validated to ensure required fields are filled correctly.

### Dashboard
Once logged in, users have access to various features on the dashboard:
1. **Add Personal Details**: Users must complete this section before using other services like updating information or booking packages.
2. **Update/View/Delete Personal Details**: Manage personal information.
3. **Check Packages**: View available travel packages.
4. **Book Package**: Select a package, specify the number of people, and confirm the price before booking.
5. **View Booked Packages**: See details of booked packages or receive a message if no bookings have been made.
6. **View Hotels**: A slideshow of available hotels, displaying images and details.
7. **Book/View Booked Hotels**: Users can book hotels or view their previous bookings.
8. **Destinations**: A slideshow of popular tourist destinations.
9. **Payments**: Redirects to an external payment page.
10. **Utilities**: Access a calculator and notepad from the dashboard.
11. **About**: Information about the application.

Feedback is provided for each action, confirming successful operations such as bookings and updates.

## Technology Stack
- **Java**: Application logic and UI built using Java Swing.
- **MySQL**: Database for managing user data, bookings, and packages.
- **Multi-threading**: Used to implement animations (e.g., window expansion, loading progress bars) and improve UI responsiveness.

## Installation Guide

1. **Prerequisites**:
    - Java Development Kit (JDK) 8 or higher.
    - MySQL installed and running.
    - MySQL JDBC driver configured in your project.

2. **Steps**:
    1. Clone the repository to your local machine.
    2. Run the provided SQL script, named `travel_management_schema.sql`. This script will automatically create the `travel_management_system` database and initialize the necessary tables.
    3. Update the database connection settings (JDBC URL, username, password) in the project code.
    4. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse) and run it.

## Database Schema
The database schema is defined in the `travel_management_schema.sql` file and includes:
- **Users**: Stores user credentials, security questions, and answers.
- **Personal Details**: Stores user personal information.
- **Packages**: Stores travel package details.
- **Booked Packages**: Tracks package bookings made by users.
- **Hotels**: Stores hotel details for booking.
- **Booked Hotels**: Tracks hotel bookings by users.

## Usage Instructions
1. Launch the application, and the login window will appear.
2. Use the login screen to log in or create an account via the signup page.
3. Once logged in, navigate the dashboard to:
    - Add or update personal details.
    - View, check, and book travel packages or hotels.
    - Use utilities like the calculator or notepad.
    - Redirect to the external payment page for payments.
4. Feedback messages will confirm successful operations throughout the application.

## Validation & Feedback
Every form in the system includes input validation, ensuring required fields are filled before submission. Feedback is provided after actions such as account creation, package bookings, and password retrieval.

## Author
This project was developed by **Monu Kumar** and is available on GitHub. You can view the source code and contribute to the project via [travel-and-tourism-management-system](https://github.com/monukd01dev/travel-and-tourism-management-system/tree/master). For more projects and information, visit my [GitHub profile](https://github.com/monukd01dev).
