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

## 📝 TODO

- [ ] Frontend-Login an den `auth-service` anbinden (JWT, Login-Formular, Session-Handling)
- [x] Auth-Service Grundstruktur angelegt (noch nicht mit Frontend verbunden)
- [x] Account-Service und Frontend lauffähig mit Docker Compose

---

## 📸 Screenshots

Der aktuelle Screenshot des Frontends ist im PDF hinterlegt:  
[`docs/frontend.pdf`](docs/frontend.pdf)

---

## 🎯 Projektziele & Bezug zur Stelle

Dieses Projekt wurde **gezielt für meine Bewerbung als Full-Stack Entwickler (m/w/d) bei der CPU Consulting & Software GmbH** entwickelt.

**Das sind die Ziele & Bezugspunkte:**
- **Demonstration moderner Fullstack-Entwicklung** mit Java (Spring Boot) und Angular gemäß aktueller Best Practices im Bankenumfeld
- **Microservice-Architektur** in modularer, wartbarer Struktur – als Basis für skalierbare Bankanwendungen
- **Clean Code und Layering**, klare Trennung von Frontend und Backend, Verwendung von DTOs und Exceptions
- **DevOps & Agile Methoden:** Docker Compose, automatisierbare Builds, Fokus auf kollaborative Entwicklung
- **Fokus auf Qualität, Erweiterbarkeit und Teamfähigkeit:** 
    - Umsetzung von Code-Reviews (Pull-Requests)
    - Vorbereitung für Authentifizierung & Security (auth-service als TODO)
    - Dokumentation und strukturierter Aufbau

**Ich bringe mit:**
- Nachweisbare Erfahrung in Angular, TypeScript, Java, Spring Boot, (S)CSS, HTML5 und Docker
- Praxis in agiler Entwicklung, Clean Code und modularer Softwarearchitektur
- Sehr gute Deutschkenntnisse, Teamfähigkeit und Qualitätsbewusstsein

**Mein Ziel:**  
Meine Begeisterung für Fullstack-Entwicklung und mein Know-how im Bereich moderner Bankensoftware ins Team der CPU Consulting & Software GmbH einzubringen – als motivierter, lernbereiter und verantwortungsbewusster Entwickler.

---

## 👤 Autor

**Duc Thanh Nguyen**  
🔗 [GitHub-Portfolio](https://github.com/thanhtuanh/bewerbung)  
📧 [n.thanh@gmx.de](mailto:n.thanh@gmx.de)
