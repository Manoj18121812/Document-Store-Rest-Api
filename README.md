# 📦 Document Storage REST API  
** – Spring Boot Daily REST API Project**  

A medium–high level real-world REST API that allows users to upload, store, download, list, and delete files such as PDFs, images, and documents.

---

## 🚀 Features

### 📁 File Operations  
- ✅ Upload File (PDF / Image / Any type)  
- ✅ Store File in MySQL as **BLOB**  
- ✅ Download File by ID  
- ✅ List All Uploaded Files  
- ❌ Delete File  

### 🧩 Architecture  
- ✔ Controller  
- ✔ Service  
- ✔ Repository  
- ✔ DTO (FileResponseDTO)

---

## 🏗️ Tech Stack

| Layer | Technology |
|------|------------|
| Backend | Spring Boot |
| Database | MySQL |
| ORM | Spring Data JPA |
| Testing | Postman |
| Optional | Lombok, DevTools |

---

## 📦 Spring Initializr Dependencies

Add these dependencies:

- **Spring Web**  
- **Spring Data JPA**  
- **MySQL Driver**  
- **Lombok** (Optional but recommended)  
- **Spring Boot DevTools** (Optional)

---

## 🔧 Configuration (application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/file_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10MB




src/main/java/com/example/file/
│
├── controller/
│     └── DocumentController.java
│
├── service/
│     └── DocumentService.java
│
├── repository/
│     └── DocumentRepository.java
│
├── entity/
│     └── DocumentFile.java
│
├── dto/
│     └── FileResponseDTO.java
│
└── FileApplication.java

