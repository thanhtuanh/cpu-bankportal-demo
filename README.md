# 💼 CPU Bankportal Demo – Fullstack Java + Angular Microservices

Dieses Projekt demonstriert ein modernes Online-Banking-Portal auf Basis einer Microservice-Architektur – entwickelt mit **Spring Boot (Java)** und **Angular (TypeScript)**, bereitgestellt über **Docker Compose**.

---

## 🚀 Projektüberblick

Das Bankportal besteht aus mehreren eigenständigen Services:

- **Frontend:** Angular-App (`/frontend`)
- **Backend:** Microservices
  - **Account Service** (`/account-service`): Verwaltung von Konten und Kontobewegungen
  - **Auth Service** (`/auth-service`): Authentifizierung & (optional) Autorisierung (siehe TODO)

---

## 🏦 Hauptfunktionen

| Funktion               | Beschreibung                                                |
|------------------------|------------------------------------------------------------|
| Kontoübersicht         | Anzeige vorhandener Konten und Salden (`/accounts`)         |
| Überweisung ausführen  | Formular zur Durchführung einer Überweisung (`/transfers`)  |
| Benutzerliste          | Statische Benutzerübersicht (erweiterbar)                   |
| Login (optional)       | Dummy-Login oder JWT-basiert möglich (siehe TODO)           |

---

## 🧰 Tech-Stack

**Backend-Services**
- Java 17, Spring Boot 3 (Web, Data JPA, Validation)
- REST APIs, DTOs, Exception Handling
- H2 (Standard) oder PostgreSQL (optional)
- Maven Wrapper

**Frontend**
- Angular 17, Angular Material, SCSS
- TypeScript, Reactive Forms, HttpClient

**DevOps**
- Docker, Docker Compose
- Git, GitHub Actions (optional)

---

## 🧪 Architektur

```text
.
├── account-service      # Spring Boot Microservice für Konten
├── auth-service         # Spring Boot Microservice für Authentifizierung (TODO)
├── frontend             # Angular Anwendung
├── docs                 # Projektdokumentation
├── docker-compose.yml   # Multi-Container Setup
├── README.md
└── ...
```

```text
+----------------+       REST        +---------------------+
|   Angular App  | <--------------> | Account Service     |
|  (Frontend)    |                  +---------------------+
+----------------+       REST        +---------------------+
                                <--> | Auth Service (TODO) |
                                     +---------------------+
```

---

## ▶️ Lokaler Start (nur mit Docker Compose)

Voraussetzung: **Docker** & **Docker Compose** sind installiert.

Im Hauptverzeichnis des Projekts:

```bash
docker-compose up --build
```

- **Frontend:** [http://localhost:4200](http://localhost:4200)
- **Backend Account-Service:** [http://localhost:8080](http://localhost:8080)
- **Backend Auth-Service:** (Port ggf. in `docker-compose.yml` einsehen, aktuell als TODO)

Beenden mit:

```bash
docker-compose down
```

---

## 🛣️ Roadmap & Weiterentwicklung
Dieses Projekt wurde mit Blick auf Erweiterbarkeit und Qualität entwickelt. Folgende Punkte sind geplant oder als zukünftige Optimierungen angedacht:

**Geplante Implementierungen (TODOs):**

- [ ] Frontend-Login an den auth-service anbinden (JWT, Login-Formular, Session-Handling)

- [x] Auth-Service Grundstruktur angelegt (noch nicht mit Frontend verbunden)

- [x] Account-Service und Frontend lauffähig mit Docker Compose

**Qualität & Testabdeckung:**

- Beide Backend-Services (account-service und auth-service) wurden mit JUnit 5-Tests umfassend getestet, um die Funktionalität und Robustheit der APIs sicherzustellen. Dies trägt zur Codequalität und Wartbarkeit bei.

- Erweiterung der Testabdeckung um Integrationstests und End-to-End-Tests.

**Architektur & Infrastruktur-Optimierungen:**

- Integration von Spring Security für den auth-service zur vollständigen JWT-basierten Authentifizierung und Autorisierung.

- Implementierung einer zentralen API-Gateway-Lösung (z.B. Spring Cloud Gateway) für Routing, Lastverteilung und zusätzliche Sicherheitsfeatures.

- Einsatz eines Message Brokers (z.B. Kafka, RabbitMQ) für asynchrone Kommunikation zwischen Microservices.

- Monitoring und Logging-Lösungen (z.B. Prometheus, Grafana, ELK Stack) für bessere Observability.

---

## 📸 Screenshots

Der aktuelle Screenshot des Frontends ist im PDF hinterlegt:  
[`docs/frontend.pdf`](docs/frontend.pdf)

---


## 👤 Autor

**Duc Thanh Nguyen**  
🔗 [GitHub-Portfolio](https://github.com/thanhtuanh/bewerbung)  
📧 [n.thanh@gmx.de](mailto:n.thanh@gmx.de)
