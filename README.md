# My Personal Budget Application

A Spring Boot application for managing personal budgets and tracking transactions.

## Technologies Used
- Spring Boot
- Spring Data JPA
- Thymeleaf
- MySQL / H2 Database
- Docker
- RESTful API
- Swagger/OpenAPI Documentation

## Running the Application

### Local Development (H2 Database)

To run the application locally with the H2 in-memory database (default):

```shell
./mvnw spring-boot:run
```

Access the application at http://localhost:8080/dashboard
Access the H2 console at http://localhost:8080/budget_h2
Access the Swagger UI at http://localhost:8080/swagger-ui.html

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
- RESTful API for transaction management

## API Documentation

### Swagger/OpenAPI Documentation
The application includes interactive API documentation using Swagger UI. You can access it at:
```
http://localhost:8080/swagger-ui.html
```

This provides:
- Interactive API documentation
- Try-it-out functionality
- Request/response schemas
- Authentication details (if configured)

### Transaction Endpoints

Base URL: `http://localhost:8080/api/dashboard`

#### Get All Transactions
```http
GET /all
```
Returns a list of all transactions.

#### Get Transaction by ID
```http
GET /{id}
```
Returns a specific transaction by its UUID.

#### Create Transaction
```http
POST /
```
Creates a new transaction.

Request body:
```json
{
    "amount": 100.00,
    "description": "Grocery shopping",
    "category": "Food",
    "type": "EXPENSE",
    "date": "2024-03-20T14:30:00"
}
```

#### Update Transaction
```http
PUT /update/{id}
```
Updates an existing transaction.

Request body:
```json
{
    "amount": 150.00,
    "description": "Updated grocery shopping",
    "category": "Food",
    "type": "EXPENSE",
    "date": "2024-03-20T14:30:00"
}
```

#### Delete Transaction
```http
DELETE /{id}
```
Deletes a transaction by its UUID.

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

### Testing the API
You can test the API endpoints using tools like:
- cURL
- Postman
- Any HTTP client library (e.g., Axios, Fetch API)

Example using cURL:
```bash
# Get all transactions
curl http://localhost:8080/api/dashboard/all

# Create a transaction
curl -X POST http://localhost:8080/api/dashboard \
-H "Content-Type: application/json" \
-d '{
    "amount": 100.00,
    "description": "Grocery shopping",
    "category": "Food",
    "type": "EXPENSE",
    "date": "2024-03-20T14:30:00"
}' 