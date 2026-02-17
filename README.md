# 🔗 URL Shortener – Spring Boot & MySQL

A simple and efficient **URL Shortener application** built using **Spring Boot** and **MySQL**.  
This project allows users to convert long URLs into short links and automatically redirects users to the original URL when accessed.

---

## 📌 Features
- Generate short URLs from long URLs
- Redirect short URLs to original URLs
- RESTful API implementation
- Persistent storage using MySQL
- Clean layered architecture (Controller, Service, Repository)
- Error handling for invalid short URLs

---

## 🛠️ Tech Stack
- **Backend:** Java, Spring Boot
- **Database:** MySQL
- **ORM:** Spring Data JPA (Hibernate)
- **Build Tool:** Maven
- **Server:** Embedded Tomcat
- **API Testing:** Postman / Browser

---
```text
src/main/java
 └── com.example.url_shortener
     ├── controller
     ├── service
     ├── repository
     └── model
```

## ▶️ How to Run the Project

```bash
# Clone the repository
git clone https://github.com/your-username/url-shortener.git

# Create the database
CREATE DATABASE url_shortener;

# Update database credentials in:
# src/main/resources/application.properties

# Run the application
mvn spring-boot:run

# Test APIs using Postman or a web browser
