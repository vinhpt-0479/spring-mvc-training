# Spring Boot CRUD Application Demo

## Overview
This project is a simple CRUD (Create, Read, Update, Delete) application built using Spring Boot, Hibernate, and PostgreSQL. It demonstrates the basic operations that can be performed on a database through a RESTful API. The application manages `users`, allowing clients to create, retrieve, update, and delete user information in a PostgreSQL database.

## Technologies
- **Spring Boot**: Simplifies the bootstrapping and development of new Spring applications.
- **Hibernate**: Provides a framework for mapping an object-oriented domain model to a relational database.
- **PostgreSQL**: An open-source relational database management system (RDBMS) emphasizing extensibility and SQL compliance.

## Features
- Create new users
- Retrieve all users
- Retrieve a single user by ID
- Update user information
- Delete a user by ID

## Getting Started
To run this project, you will need to have Java and Maven installed on your machine. Additionally, you should have PostgreSQL set up and configured.

### Steps:
1. Clone the repository to your local machine.
2. Navigate to the project directory and run `mvn spring-boot:run` to start the application.
3. The application will be available at `http://localhost:8080`.

## API Endpoints
- `GET /welcome` - Welcome message
- `POST /users` - Create a new user
- `GET /users` - Retrieve all users
- `GET /users/{id}` - Retrieve a user by ID
- `PUT /users/{id}` - Update a user's information
- `DELETE /users/{id}` - Delete a user

## Configuration
Ensure your `application.properties` file is configured with your PostgreSQL database information:

```properties
spring.application.name=sprint-boot-demo

# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/databasename
spring.datasource.username=username
spring.datasource.password=password

# Hibernate Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect