
# 💼 CPU Bankportal Demo – Fullstack Java + Angular

Dieses Projekt wurde im Rahmen meiner Bewerbung bei der **CPU Consulting & Software GmbH** als *Fullstack Entwickler (m/w/d)* erstellt.  
Es demonstriert eine moderne Webanwendung mit **Spring Boot (Java)** und **Angular (TypeScript)** im Microservice-Stil, ergänzt durch **Docker**, REST-API und Clean Code Prinzipien.

---

## 🚀 Projektübersicht

Das Bankportal-Demo besteht aus zwei Hauptkomponenten:

- **Frontend:** Angular-Anwendung mit TypeScript, Angular Material, SCSS  
- **Backend:** Spring Boot Microservices mit REST-API, Datenpersistenz und Service-Kommunikation

### 🏦 Funktionen (Demo-Zweck)

| Funktion | Beschreibung |
|----------|--------------|
| Kontoübersicht | Anzeige vorhandener Konten mit Salden (Backend-API: `/accounts`) |
| Überweisung ausführen | Formular zur Durchführung einer einfachen Überweisung (POST `/transfers`) |
| Benutzerliste | Statische Benutzerübersicht (Optional erweiterbar) |
| Login (optional) | Dummy-Login oder JWT-basiert möglich |

---

## 🧰 Verwendete Technologien

### 📌 Backend
- Java 17
- Spring Boot 3 (Web, Data JPA, Validation)
- REST API, DTOs, Exception Handling
- H2 / PostgreSQL
- Docker, Docker Compose

### 💡 Frontend
- Angular 17
- TypeScript, Angular Material, SCSS
- Reactive Forms, HttpClient
- Routing & Komponentenstruktur

### 🛠 DevOps & Tools
- Dockerfile, `docker-compose.yml`
- Git, GitHub Actions (Optional: Jenkins)
- Maven Wrapper

---

## 🧪 Architekturüberblick

```text
+----------------+        REST        +------------------+
|   Angular App  | <----------------> | Spring Boot API  |
+----------------+                   +------------------+
    Kontoansicht                         /accounts
    Überweisungsformular                 /transfers
````

---

## ▶️ Lokaler Start

### 1. Backend starten

```bash
cd backend
./mvnw spring-boot:run
# oder via Docker
docker build -t cpu-backend .
docker run -p 8080:8080 cpu-backend
```

### 2. Frontend starten

```bash
cd frontend
npm install
ng serve
# oder via Docker
docker build -t cpu-frontend .
docker run -p 4200:80 cpu-frontend
```

### 3. Alternativ: Docker Compose

```bash
docker-compose up --build
```

---

## 📸 Screenshots

> (Hier ggf. Screenshots des Frontends einfügen)

---

## 💬 Zielsetzung & Bezug zur Stelle

Dieses Demo-Projekt zeigt meine Fähigkeiten im Bereich:

* **Fullstack-Entwicklung mit Java, Spring Boot und Angular**
* **Clean Code, Layering und RESTful API Design**
* **Modularer Aufbau und DevOps-Ansätze mit Docker**

Ich freue mich darauf, dieses Projekt im persönlichen Gespräch weiter zu erläutern und gemeinsam mit dem CPU-Team spannende Softwarelösungen zu gestalten.

---

## 👤 Autor

**Duc Thanh Nguyen**
🔗 [GitHub-Portfolio mit weiteren Projekten](https://github.com/thanhtuanh/bewerbung)
📧 [n.thanh@gmx.de](mailto:n.thanh@gmx.de)

```
