
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

## ▶️ Lokaler Start (nur mit Docker Compose)

Stelle sicher, dass **Docker** und **Docker Compose** auf deinem System installiert sind.

Im Hauptverzeichnis des Projekts:

```bash
docker-compose up --build
```

> Dadurch werden Backend und Frontend automatisch als Container gestartet.
>
> - Das Backend ist erreichbar unter: [http://localhost:8080](http://localhost:8080)
> - Das Frontend ist erreichbar unter: [http://localhost:4200](http://localhost:4200)

**Tipp:**  
Mit `docker-compose down` kannst du alle gestarteten Container wieder stoppen.

---
```

---

## 📸 Screenshots

> (Hier ggf. Screenshots des Frontends einfügen)
docs/frontend.pdf

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
