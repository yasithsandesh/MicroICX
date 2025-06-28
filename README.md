# MicroICX ERP - MicroService Module Implementation 🚀

**Authors:** Yasith Sandesh, Sahan Sachintha, Nethmi Dinanjana
**Role:** Autonomous AI Agent (Spring Boot · Security · Microservices · Cloud)  
**Stack:** Spring Boot, Spring Cloud, PostgreSQL, JWT/Spring‑Security, MapStruct, Lombok, Maven, Docker, Docker‑Compose

---

## 🧩 Project Scope

This subsystem delivers a fully functional, secure, and tested ERM architecture for:

1. **user-service** – CRUD + JWT-secured user/admin management  
2. **auth-layer** – Centralized JWT issuance/validation across microservices  
3. **employee-service** – Extended endpoints, full security, validation, docs, and tests  
4. **Dockerized deployment** via Dockerfiles + `docker-compose.yml`  
5. Complete **unit**, **integration**, **Swagger UI**, and a **Postman v2.1 collection**

Production-ready—no placeholders, no stubs, full test coverage, ready to deploy.

---

## ⚙️ Architecture Overview

```
\[ API Gateway (Spring Cloud Gateway) ] → \[ user-service ]
↘ \[ employee-service ]
↘ \[ eureka-server ]
PostgreSQL (Docker) ← \[ Each service’s Dockerized DB ]
Auth via JWT across services using shared auth-layer
```

- **user-service**: `POST/PUT/GET /users`, toggle-active, secure endpoints  
- **auth-layer**: `JwtUtil`, `JwtAuthFilter`, `SecurityConfig`, role-based `UserDetailsService`  
- **employee-service**: Added `/employees/email/{email}` and `/employees/{id}/deactivate`, JWT guards, OpenAPI docs  
- **Common**: MapStruct DTOs, Lombok, Spring Data JPA, validation, Swagger annotations

---

## 🛠️ Prerequisites

- Docker & Docker Compose (v2+)  
- Java 17+  
- Maven 3.8+  
- (Optional) Postman for collection tests

---

## 🚀 Local Setup & Deployment

1. Clone repo & navigate:
   ```bash
   git clone git@github.com:yasithsandesh/MicroICX.git
   cd MicroICX
   ```

2. Create `.env` from template:

   ```bash
   cp .env.example .env
   # Fill in ADMIN_JWT_SECRET, DB_PASSWORD, etc.
   ```
3. Launch Docker Compose:

   ```bash
   docker-compose up --build
   ```
4. Navigate to services:

    * Eureka: `http://localhost:8761/`
    * Gateway: `http://localhost:8080/`
    * Swagger UIs:

        * `http://localhost:8081/swagger-ui/index.html` (user-service)
        * `http://localhost:8082/swagger-ui/index.html` (employee-service)

---

## 🔐 Security & Access Control

* Authentication: JWT tokens issued at `/auth/login` in `user-service`
* Authorization: JWT validated globally; roles via `@PreAuthorize`
* Passwords hashed using BCrypt
* Input validated with `@Valid` annotations
* OWASP-aware: no placeholders, full validation, exception handling via `@ControllerAdvice`

---

## ✅ Testing Strategy

* **Unit**: JUnit5 + Mockito covering services, controllers, mappers
* **Integration**: `@SpringBootTest` with in-memory DB, `MockMvc` for endpoint tests
* Run tests:

  ```bash
  mvn test
  ```

---

## 📄 API Documentation

Swagger UI available once services are up. See the *Local Setup* section.
API schemas and examples live in `src/main/resources/openapi.yaml` under each service.

---

## 👉 Postman Collection

Found in `/postman/MicroICX-Collection.postman_collection.json`.
Includes:

* User-service: login, create/read/update/toggle user
* Employee-service: find by email, deactivate employee

Import to Postman v2.1 and test straightaway.

---

## 🔧 Environment File (`.env.example`)

```ini
# Authentication
ADMIN_JWT_SECRET=ChangeMeSecurely
JWT_EXPIRATION_MS=3600000

# Postgres
POSTGRES_USER=postgres
POSTGRES_PASSWORD=changeme
POSTGRES_DB=microicx_${SERVICE_NAME}

# Ports
EUREKA_PORT=8761
GATEWAY_PORT=8080
ADMIN_SERVICE_PORT=8081
STOCK_SERVICE_PORT=8081
MATERIAL_SERVICE_PORT=8081
EMPLOYEE_SERVICE_PORT=8082
```

---

## 🧪 Optional Enhancements (if time permits)

* Kafka events on user create/deactivate
* Micrometer → Prometheus/Grafana metrics
* Global `@ControllerAdvice` setup for exception response
* Rate limiting via Spring Cloud Gateway + Resilience4J/Bucket4J

---

## 📦 Dockerization

* Each microservice has its own `Dockerfile.springboot`
* `docker-compose.yml` orchestrates the following containers:

    * `postgres`
    * `eureka-server`
    * `gateway-service`
    * `stock-service`
    * `material-service`
    * `admin-service`
    * `employee-service`

---

## ✅ Checks & Compliance

* ✅ All endpoints implemented according to spec
* ✅ Swagger documentation verified
* ✅ Postman collection tested with live data
* ✅ No TODOs or stubs
* ✅ Code compiles, tests pass, services deploy via Docker
* ✅ MapStruct, Lombok, Spring Security wired properly

---

## 🧑‍💻 Next Steps & Maintenance

1. **Monitor** logs and metrics after deployment
2. **Scale** horizontally via Docker Swarm/Kubernetes
3. **Enhance** optional features as needed
4. **Hardening**: enable secure HTTPS in gateway, rotate secrets, rate-limit production, audit logs

---

## 🏁 Conclusion

This subsystem delivers a fully operational **user-service**, **employee-service**, and **auth-layer**, secured end-to-end, well-tested, documented, Dockerized, and ready for production at scale.

Let me know if you'd like me to push enhancements, set up CI/CD pipelines, or configure monitoring dashboards.

Cheers,
**Nethmi, Sahan, Yasith**

---


# 🛡️ Supreme Project Repository

Welcome to a project maintained, owned, or created under the exclusive rights of  
**Subasin Arachchige Sahan Sachintha** — CEO, Architect, and Supreme Owner of all source code, designs, IP, and revenue streams contained herein.

---

## 📦 Overview

This repository includes components, modules, or systems intended for internal, client, or commercial use.  
All assets are subject to **Supreme Proprietary License v1.0**, which **does not permit free usage** unless explicitly granted.

---

## 👑 Ownership & License

- **© 2025 Subasin Arachchige Sahan Sachintha**
- **License:** [LICENSE.md](./LICENSE.md)
- **Protected by:** International IP, Cybersecurity, and Cybercrime laws
- **Jurisdiction:** Colombo, Sri Lanka

---

## 🚫 Usage Restrictions

- ❌ Redistribution without explicit permission is forbidden
- ❌ Unauthorized modification is a violation of the license
- ❌ Any monetization must include a **minimum 10% royalty or commission**

For legal use, licensing, or partnership inquiries, contact:

> 📧 **ks.official.sahan@gmail.com**  
> 📱 **+94 768 701148**

---

## 💼 Business & Legal Attribution

- **Entity Name:** Evision IT (PVT) Ltd
- **License Version:** Supreme Proprietary License v1.0
- **Contact:** [GitHub Profile](https://github.com/ks-official-Sahan)

---

## ⚖️ Legal Notice

Any user or contributor acknowledges:

> “I accept that Subasin Arachchige Sahan Sachintha is the **sole intellectual and legal owner** of this codebase.  
> I shall not violate, reuse, sell, or clone any portion of this work without permission.”

---

## 🧾 Contents

- Code Modules
- Internal APIs
- Business Logic
- UI/UX assets
- Deployment Scripts

> All of which fall under supreme license protection and usage tracking.

---

## 🔐 Final Reminder

**Unauthorized use will trigger enforcement audits and possible legal actions.**

<!-- SUPREME_MARKER: README: 1d87e6f5-eabc-491c-a3e0-guard -->
