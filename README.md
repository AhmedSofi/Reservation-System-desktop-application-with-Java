# Air Reservation System

A Java desktop application for managing flight reservations, customer bookings, and ticket management.

## 🛫 Overview

This airline reservation system allows airlines to manage flights, customers, and ticket bookings. It supports different ticket classes (Business and Economy), seat management, and provides database integration through SQL.

## ✨ Features

- **Customer Management**: Create and manage customer profiles with names and email addresses
- **Flight Management**: Define flights with origin, destination, date/time, and pricing
- **Ticket Classes**: Support for Business and Economy ticket classes
- **Seat Allocation**: Advanced seat management for different plane configurations
- **Special Services**: Add special meal options for Business class tickets
- **Database Integration**: SQL database for persistent data storage
- **Reservation System**: Book tickets with validation for seat availability
- **Price Calculation**: Dynamic pricing based on ticket type

## 🏗️ System Architecture

The application follows object-oriented design principles with the following key classes:

- **Customer**: Manages customer information and their tickets
- **Flight**: Handles flight details and seat availability
- **Plane**: Defines plane configuration with business and economy seats
- **Ticket**: Base class for different ticket types (Business, Economy)
- **ReservationSystem**: Core system for handling the reservation process
- **SQL Integration**: Database connectivity through specialized SQL classes

## 💻 Usage Example

```java
// Create customers
Customer customer = new Customer("Ahmed", "ahmed@gmail.com");

// Define plane configuration (business seats, economy seats)
Plane plane = new Plane(2, 18);

// Create a flight
Flight flight = new Flight(plane, "CAI", "ITA", "2023-08-24T22:45:00", 100);

// Reserve tickets
try {
    ReservationSystem.reserve(1, customer, flight, "business");
} catch(NoAvailableTicketsException e) {
    System.out.println("No tickets available");
}

// View customer details
ReservationSystem.showCustomerDetails(customer);
```

## 🛠️ Technical Details

- **Language**: Java
- **Database**: SQL (with custom implementation)
- **Project Structure**: Object-oriented with inheritance hierarchy for ticket types
- **Exception Handling**: Custom exceptions for business logic (e.g., NoAvailableTicketsException)

## 🚀 Getting Started

1. Ensure you have Java installed on your system
2. Set up a SQL database using the configuration in `hibernate.cfg.xml`
3. Compile the Java files
4. Run the Main class to start the application

## 📋 Database Setup

The application requires a database connection. Configure your database details in the `hibernate.cfg.xml` file:

```xml
<hibernate-configuration>
    <session-factory>
        <!-- Database connection settings -->
        <property name="connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="connection.url">jdbc:mysql://localhost:3306/your_database</property>
        <property name="connection.username">your_username</property>
        <property name="connection.password">your_password</property>
    </session-factory>
</hibernate-configuration>
```

## 🧪 Testing

The system can be tested through the Main.java file, which demonstrates the core functionality including:
- Creating customers
- Setting up flights and planes
- Booking different types of tickets
- Handling exceptions for unavailable seats
- Displaying ticket and customer information



