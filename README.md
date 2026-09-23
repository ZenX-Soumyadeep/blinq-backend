# BlinQ API & Database ⚙️

The RESTful Spring Boot API and containerized MySQL database powering the BlinQ platform.

## 🚀 Tech Stack
- **Language:** Java 21 LTS
- **Framework:** Spring Boot 4.1.x
- **Database:** MySQL 8.0 (Dockerized)
- **ORM:** Spring Data JPA / Hibernate
- **Tools:** Lombok, Docker Compose

## ✨ Features
- **Secure Authentication:** Registration and Login endpoints with database-level constraints against duplicate emails/phone numbers (Anti-bot).
- **Role-Based Access Control (RBAC):** Distinct `ROLE_USER` and `ROLE_ADMIN` authorities for varying levels of platform access.
- **Relational Data Mapping:** `MovieReview` entities mapped seamlessly to external TMDB Movie IDs.
- **Admin Moderation:** Protected endpoints allowing Admins to actively moderate and delete community reviews.

## 🛠️ Local Setup & Execution

### 1. Start the Database
You must have Docker installed. Spin up the MySQL container using the provided compose file to ensure database isolation:
```bash
docker compose up -d