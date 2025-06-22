
# 🛠️ Spring Boot CRUD Operation API

A simple Spring Boot project demonstrating CRUD (Create, Read, Update, Delete) operations using **Spring Web**, **Spring Data JPA**, **PostgreSQL**, and **Lombok**.

---

## 📦 Tech Stack

- **Java 21**
- **Spring Boot 3.5.0**
- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**

---

## 📁 Project Structure

```
CrudOperation
│
├── Controller
│   └── EmployeeController.java
│
├── DTO
│   └── UpdateAddressDto.java
│
├── Entity
│   └── Employee.java
│
├── Repository
│   └── EmployeeRepository.java
│
├── Service
│   └── EmployeeService.java
│
└── resources
    └── application.properties
```

---

## 🔧 Configuration

Update your `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 📦 Maven Dependencies (pom.xml)

> Key dependencies:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

---

## 🧪 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `/api/create` | Create a new employee |
| `GET`  | `/api/getAll` | Get all employees |
| `GET`  | `/api/getByName/{name}` | Get employee by name |
| `PUT`  | `/api/update/employee` | Update employee address |
| `DELETE` | `/api/delete/{name}` | Delete employee by name |

---

## 🧾 Sample JSON Payloads

### 🔹 Create Employee

```json
POST /api/create
{
  "name": "John",
  "age": 25,
  "address": "Chennai"
}
```

### 🔹 Update Address

```json
PUT /api/update/employee
{
  "name": "John",
  "address": "Bangalore"
}
```

---

## 🚀 Run the Project

```bash
mvn spring-boot:run
```

or

```bash
./mvnw spring-boot:run
```

---

## 📬 Contact

Feel free to contribute or reach out via [GitHub Issues](https://github.com/Guru6380/Spring-Boot-CRUD-Operation/issues) if you find bugs or have suggestions!

---

## 📝 License

This project is open-source and available under the [MIT License](LICENSE).
