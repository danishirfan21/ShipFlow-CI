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

## Deployment

This project is configured for deployment on **Render**.

### Deployment Setup

The deployment is managed by the `render.yaml` Blueprint file, which defines:
- **Service Type**: Web Service
- **Runtime**: Java
- **Build Command**: `mvn clean package -DskipTests`
- **Start Command**: `java -jar target/shipflow-0.0.1-SNAPSHOT.jar --server.port=${PORT:-8080}`

Render automatically detects the `render.yaml` file at the root of the repository and configures the service accordingly.

### Continuous Deployment

Once the GitHub repository is connected to Render:
1. Every push to the main branch triggers a build on Render.
2. Render uses the specified build command to package the application.
3. The application is deployed as a live service and bound to the platform-provided port.

### End-to-End Workflow

This project demonstrates a complete development lifecycle:
1. **App Code**: Spring Boot REST API with in-memory storage.
2. **Tests**: Unit and integration tests for all endpoints.
3. **Docker**: Multi-stage `Dockerfile` for local containerization and consistent environments.
4. **CI**: GitHub Actions workflow to verify every change.
5. **Deployment**: Deployment-ready configuration for Render to host the live service.
