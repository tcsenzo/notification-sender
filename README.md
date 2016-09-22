## How to deploy

### Locally
- harbor

### At ec2
- Pull the new version 

```bash
docker pull leocwolter/notifications
```

- Stop and remove the running container
```
docker stop notifications
docker rm notifications
```

- Run the container:

```bash
docker run --name notifications -d leocwolter/notifications
```

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