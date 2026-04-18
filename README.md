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

## Docker

You can also build and run the application using Docker.

### Build the Image

```bash
docker build -t shipflow-ci .
```

### Run the Container

```bash
docker run -p 8080:8080 shipflow-ci
```

The application will be accessible at `http://localhost:8080`.

## Continuous Integration

This project uses **GitHub Actions** for automated verification.

The CI pipeline (`.github/workflows/ci.yml`) automatically runs on every push and pull request to ensure that:
1. The code compiles successfully.
2. All tests pass.
3. The project can be packaged into a JAR.
4. The Docker image builds correctly.

This automated process provides immediate feedback and ensures that the application remains stable as new features are added.

### Verify in Docker

To verify the health endpoint is working inside the container:

```bash
curl http://localhost:8080/health
```
