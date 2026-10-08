# Location Tracker Backend

A RESTful backend service built using **Java 21** and **Spring Boot 3** to ingest, process, and manage real-time device location telemetry. 

The project uses **Spring Security** for HTTP Basic Authentication to protect administrative endpoints, **Spring Data JPA** for database interactions, and **PostgreSQL** as the data store.

---

## 🛠️ Tech Stack

- **Language**: Java 21
- **Framework**: Spring Boot 3 (Spring Web, Spring Security, Spring Data JPA)
- **Database**: PostgreSQL
- **Build Tool**: Gradle Wrapper

---

## 🔑 Authentication & Security

Administrative management endpoints (`/api/admin/*`) are secured using Spring Security **HTTP Basic Auth**.

- **Default Basic Auth Username**: `Om`
- **Default Basic Auth Password**: `Hope`

Public endpoints like telemetry posting and general device viewing do not require admin credentials.

---

## 📌 API Endpoints & Usage

### 1. Ingest Location Data (Public)
Send GPS location updates from a target device.

- **Endpoint**: `/api/target/post`
- **Method**: `POST`
- **Headers**: `Content-Type: application/json`

**Request Body:**
```json
{
  "device_id": "DEV-ANDROID-98765",
  "latitude": 19.9975,
  "longitude": 73.7898,
  "delay": 5
}
```

### 2. View All Tracked Devices (Public)
Fetch all current target device records and location logs.

Endpoint: /api/view

Method: GET

### 3. View Target by Device ID (Public)
Get location data for a specific device.

Endpoint: /api/view/device_id/{id}

Method: GET

### 4. Admin Management (Protected - Requires Basic Auth)
To call these endpoints in Postman, go to the Authorization tab, select Basic Auth, and enter Username: Om and Password: Hope.

Update Device Name / Username Alias
Endpoint: /api/admin/setName

Method: PUT

Query Params: device_id=DEV-ANDROID-98765&username=JohnDoe

Update Telemetry Delay Timer
Endpoint: /api/admin/time

Method: PUT

Query Params: device_id=DEV-ANDROID-98765&delay=10

Remove / Delete Device
Endpoint: /api/admin/delete

Method: DELETE

## ⚙️ Running Locally
Clone the Repository:

```
git clone [https://github.com/itsomborse/location-tracker-backend.git](https://github.com/itsomborse/location-tracker-backend.git)
cd location-tracker-backend
Configure Database Settings:
Ensure PostgreSQL is running locally and configure your connection details in src/main/resources/application.properties:

Properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_db_name
spring.datasource.username=your_postgres_user
spring.datasource.password=your_postgres_password
Build and Run:

```
==
```
./gradlew bootRun
The server will start at http://localhost:8080.
```
