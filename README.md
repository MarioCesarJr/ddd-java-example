# Project Example - Domain-Driven Design (DDD) with Spring Boot and JPA

This project is an example of implementing **Domain-Driven Design (DDD)** using **Spring Boot** and **JPA/Hibernate** to manage data persistence in a relational database. The goal is to demonstrate how to organize the code in a way that the domain model is the core part of the system, with a clear separation of layers and responsibilities.

## Project Structure

The project follows a typical layered architecture for DDD:

- **Domain Layer**: Contains the business model and business rules.
- **Application Layer**: Contains the application logic and orchestration between domain layers.
- **Infrastructure Layer**: Contains the implementation of data persistence, such as repositories, using JPA/Hibernate.
- **Presentation Layer**: Contains the REST layer as the interface.

