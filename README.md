## Example project with:
- Clean Architecture
- Spring Boot 3
- Java 17
- Gradle 8.x
- PostgreSQL
- Flyway
- Rest API
- Docker

## Features
* Users (create/update, add/remove roles, get roles, get permissions)
* Roles (creat/update, add/remove permissions)
* Permissions (create/update)

## Setup

### Swagger-ui
**http://localhost:8080/swagger-ui/index.html**

### Local
Run:
```
./gradlew build
./gradlew bootRun --args='--spring.profiles.active=dev'
```

### Docker
Build the docker image
```
./gradlew build
docker build -t hmk/system-permission-api .
```

Run the application
```
cd docker
docker-compose -f docker-compose.yml -p system-stack up
```
