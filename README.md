# MapStruct Service Demo

This project is a **Spring Boot 3** application (Java 17) that demonstrates how to use **MapStruct** together with **Lombok** to map between `Entity` and `DTO` objects.  
It also provides a simple **in-memory repository**, **service layer**, **REST API**, and **JUnit tests**.

---

## 🚀 Features

- Java 17 + Spring Boot 3
- Lombok for boilerplate code reduction
- MapStruct for type-safe and fast object mapping
- In-memory repository with sample data
- Service & Controller layers
- REST API with `ResponseEntity`
- JUnit 5 tests
- Maven project (easy to run and build)

---

## 📂 Project Structure

```text
mapstruct-service-demo
├── src
│   ├── main
│   │   ├── java/com/example/demo
│   │   │   ├── entity          # User entity
│   │   │   ├── dto             # UserDTO
│   │   │   ├── mapper          # UserMapper (MapStruct)
│   │   │   ├── repository      # In-memory UserRepository
│   │   │   ├── service         # UserService
│   │   │   ├── controller      # UserController (REST API)
│   │   │   └── DemoApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test/java/com/example/demo
│       └── UserServiceTest.java
└── pom.xml