# WhatsApp Chatbot Backend Simulation

A REST API built with Java 17 and Spring Boot 3 that simulates a WhatsApp Business webhook receiver. It accepts incoming messages, generates predefined replies, and logs every interaction.

---

## Features

- Accepts POST requests simulating WhatsApp messages
- Replies intelligently based on message content
- Logs every message with a unique ID and timestamp
- Exposes a logs endpoint to view all interactions
- Clean MVC architecture with separated concerns

---

## Tech Stack

Technology | Purpose
Java 17 | Core language
Spring Boot 3 | REST API framework
Maven | Build and dependency management
Jackson | JSON serialization / deserialization
SLF4J + Logback | Structured console logging
Docker | Containerization

---

## Project Structure

src/
└── main/
    ├── java/com/example/whatsappbot/
    │   ├── WhatsappbotApplication.java     App entry point
    │   ├── controller/
    │   │   └── WebhookController.java      Handles HTTP requests
    │   ├── model/
    │   │   ├── MessageRequest.java         Incoming JSON structure
    │   │   ├── MessageResponse.java        Outgoing JSON structure
    │   │   └── MessageLog.java             Log entry structure
    │   └── service/
    │       ├── BotService.java             Reply logic
    │       ├── LoggingService.java         Logging coordinator
    │       └── MessageLogRepository.java   In-memory data store
    └── resources/
        └── application.properties          App configuration

---

## API Endpoints

POST /webhook
Receives a message and returns a bot reply.

Request Body:
{
  "sender": "Alice",
  "message": "Hi"
}

Response:
{
  "reply": "Hello!"
}

---

GET /webhook/logs
Returns all logged messages.

Response:
[
  {
    "id": "a1b2c3d4-e5f6-...",
    "timestamp": "2024-01-15T10:30:00.123",
    "sender": "Alice",
    "message": "Hi",
    "reply": "Hello!"
  }
]

---

## Bot Reply Logic

Message (case-insensitive) | Reply
hi / hello                 | Hello!
bye / goodbye              | Goodbye!
help                       | Available commands: Hi, Bye
anything else              | Sorry, I don't understand.

---

## Getting Started

Prerequisites
- Java 17
- Maven 3.x
- IntelliJ IDEA (recommended)

Run Locally

1. Clone the repository
git clone https://github.com/YOUR_USERNAME/whatsappbot.git
cd whatsappbot

2. Build the project
mvn clean package -DskipTests

3. Run the application
mvn spring-boot:run

The server starts at http://localhost:8080

---

## Testing

Using Postman
Method  : POST
URL     : http://localhost:8080/webhook
Body    : raw -> JSON

Test cases:
{ "sender": "Alice", "message": "Hi" }
{ "sender": "Bob",   "message": "Bye" }
{ "sender": "Alice", "message": "What is AI?" }

Using curl (Windows Command Prompt)
curl -X POST http://localhost:8080/webhook -H "Content-Type: application/json" -d "{\"sender\": \"Alice\", \"message\": \"Hi\"}"

View all logs - open in browser:
http://localhost:8080/webhook/logs

---

## Running with Docker

1. Build the image
docker build -t whatsappbot .

2. Run the container
docker run -p 8080:8080 whatsappbot

The server starts at http://localhost:8080

---

## Architecture

Incoming POST Request (JSON)
        ↓
  WebhookController       receives and routes the request
        ↓
    BotService            determines the reply
        ↓
  LoggingService          creates and saves the log entry
        ↓
MessageLogRepository      stores in-memory list
        ↓
Outgoing Response (JSON)

---

## Notes

- Message logs are stored in-memory and reset when the app restarts
- For production use, replace MessageLogRepository with a real database like PostgreSQL with Spring Data JPA
- All message matching is case-insensitive

