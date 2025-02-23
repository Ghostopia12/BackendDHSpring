# BackendDHSpring

This is a simple backend API built with Spring Boot, JPA, and PostgreSQL (or H2 for testing). It provides CRUD operations for managing items with the following properties:

title: string

description: string

status: enum [FrontEnd, BackEnd, FullStack, DevOps, QA, Architect]

creation_date: date (format: YYYYMMDD HH|mm|ss)

update_date: date (format: YYYYMMDD HH|mm|ss)

## Technologies Used

Spring Boot (REST API)

Spring Data JPA (Persistence)

PostgreSQL (Database) or H2 (In-memory testing)

Lombok (Boilerplate reduction)

Spring Validation (Input validation)

## Getting Started

1. Clone the repository

git clone https://github.com/your-repo/spring-boot-crud.git
cd spring-boot-crud

2. Configure the Database

Using H2 (for testing)

Modify src/main/resources/application.properties:

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true

Using PostgreSQL

Modify src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

3. Build and Run the Application

mvn spring-boot:run

The API will be available at: http://localhost:8080/api/items

## API Endpoints

Method

Endpoint

Description

GET

/api/items

Retrieve all items

GET

/api/items/{id}

Retrieve an item by ID

POST

/api/items

Create a new item

PUT

/api/items/{id}

Update an existing item

DELETE

/api/items/{id}

Delete an item

## Testing API with cURL

Create an Item

curl -X POST http://localhost:8080/api/items -H "Content-Type: application/json" -d '{
    "title": "Backend Project",
    "description": "Spring Boot API development",
    "status": "BACKEND"
}'

Get All Items

curl -X GET http://localhost:8080/api/items

Update an Item (Example ID=1)

curl -X PUT http://localhost:8080/api/items/1 -H "Content-Type: application/json" -d '{
    "title": "Updated Title",
    "description": "Updated Description",
    "status": "FULLSTACK"
}'

Delete an Item (Example ID=1)

curl -X DELETE http://localhost:8080/api/items/1


