# ShipFlow CI

ShipFlow CI is a minimal Spring Boot API foundation designed for CI/CD, Docker, and deployment pipeline work.

## Features

- **Health Check**: `GET /health` returns `OK`.
- **Message API**:
    - `POST /messages`: Accepts a JSON body with `text` (must not be blank).
    - `GET /messages`: Returns all stored messages as JSON.

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Boot Test
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

### Build

```bash
mvn clean install
```

### Run Tests

```bash
mvn test
```

### Run the Application

```bash
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`.
