# ShipFlow CI

ShipFlow CI is a deployment-ready Spring Boot API designed to demonstrate a complete CI/CD lifecycle, containerization, and automated deployment. It provides a clean, validated REST API for message management, supported by an automated verification pipeline.

## Overview

The goal of this project is to showcase a modern DevOps workflow. It moves beyond simple application code to include Docker containerization, automated testing via GitHub Actions, and deployment-ready configuration for cloud platforms like Render.

## Tech Stack

- **Framework**: Java 17 / Spring Boot 3
- **Build Tool**: Maven
- **Containerization**: Multi-stage Docker
- **CI/CD**: GitHub Actions
- **Deployment**: Render (Blueprint configuration)
- **Testing**: JUnit 5, MockMvc

## API Design

The service provides a minimal yet robust set of endpoints:

| Method | Endpoint    | Description                          |
|--------|-------------|--------------------------------------|
| `GET`  | `/health`   | Service health check                 |
| `GET`  | `/messages` | Retrieve all stored messages         |
| `POST` | `/messages` | Submit a new message (validated)     |

### Validation
The `POST /messages` endpoint includes server-side validation. Requests must contain a JSON body with a `text` field that is not blank. Invalid requests return a `400 Bad Request`.

## Infrastructure & DevOps

### Dockerization
The project uses a **multi-stage Dockerfile** to optimize image size and security:
1. **Build Stage**: Uses `maven:3.9.6-eclipse-temurin-17` to compile and package the app.
2. **Runtime Stage**: Uses `eclipse-temurin:17-jre` for a lightweight, secure production environment.

### CI Pipeline (GitHub Actions)
The automated CI workflow (`.github/workflows/ci.yml`) triggers on every push and pull request. It ensures:
- Full compilation and dependency resolution.
- Execution of all unit and integration tests.
- Successful Maven packaging.
- Docker image build verification.

### Deployment (Render)
ShipFlow CI is configured for automated deployment via **Render Blueprints**. The `render.yaml` file defines the infrastructure as code:
- Automatic environment setup for Java 17.
- Integration with the build pipeline.
- Dynamic port binding for live service access.

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- Docker (optional)

### Local Development
1. Clone the repository.
2. Build the project:
   ```bash
   mvn clean install
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   The API will be available at `http://localhost:8080`.

### Running with Docker
Build and run the containerized application:
```bash
docker build -t shipflow-ci .
docker run -p 8080:8080 shipflow-ci
```

### Running Tests
Execute the test suite to verify application logic:
```bash
mvn test
```

## End-to-End Workflow

1. **Development**: Feature branch creation and local testing.
2. **Validation**: GitHub Actions runs the CI suite on pull request.
3. **Packaging**: Docker builds a production-ready image.
4. **Deployment**: Once the repository is connected to Render, merges to `main` can trigger an automated rollout.

## Future Improvements

- Implementation of a persistent database (e.g., PostgreSQL).
- Integration of API documentation (Swagger/OpenAPI).
- Enhanced observability with Spring Boot Actuator and Prometheus.
