# My Personal Budget Application

A Spring Boot application for managing personal budgets and tracking transactions.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL / H2 Database
- Docker

## Running the Application

### Local Development (H2 Database)

To run the application locally with the H2 in-memory database (default):

```shell
./mvnw spring-boot:run
```

Access the application at http://localhost:8080/dashboard
Access the H2 console at http://localhost:8080/budget_h2

### Local Development (MySQL)

To run the application with MySQL:

1. Start MySQL:
```shell
docker run --name budget-mysql -e MYSQL_DATABASE=budget_db -e MYSQL_USER=budget_user -e MYSQL_PASSWORD=budget_password -e MYSQL_ROOT_PASSWORD=root_password -p 3306:3306 -d mysql:8.0
```

2. Run the application with MySQL profile:
```shell
./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

### Using Docker Compose

To run the entire application stack with Docker Compose:

1. Update the environment variable in docker-compose.yml:
```yaml
environment:
  - SPRING_PROFILES_ACTIVE=mysql
```

2. Run docker-compose:
```shell
docker compose up -d
```

This will start both the MySQL database and the application container.

## Features
- Create, update, and delete transactions
- Track income and expenses
- View overall budget balance

## Development

### Configuration Files
- `application.yaml` - Default configuration with H2 database settings
- `application-mysql.yaml` - MySQL-specific configuration (activated with `spring.profiles.active=mysql`)

### Database Schema
The application uses a simple schema with a transactions table:
- id: Primary key
- transaction_id: UUID for transaction identification
- type: INCOME or EXPENSE
- category: Transaction category
- amount: Transaction amount
- description: Transaction description
- date: Transaction date and time 