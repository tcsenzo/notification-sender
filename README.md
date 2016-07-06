## How to setup

- Import the project as an Existing Maven Project at eclipse

## How to run

- If you have the project imported, just run the class com.senzo.qettal.PushSenderApplication
- If you don't, run 'mvn spring-boot:run' at your terminal

## How to send notifications

### Prerequisites

- Before you can send notifications, you need to setup and run the project https://github.com/tcsenzo/theater-events

### Endpoint

```bash
curl http://localhost:8081/send
```