# Students

Project that contains REST service to enroll student in a class.

## Getting Started

This are instructions on how to start the application.

### Prerequisites

```
Docker
```

## Running

```
docker-compose up -d
```

## Connecting to REST

**GET**
```
http://localhost:8080/findClass/ma
http://localhost:8080/classes
```

**POST**
```
http://localhost:8080/enroll (with form-data: class=Math&auth=GRJWLFJM7V or auth=6MVCV8XE46)
http://localhost:8080/cancelEnrollment (with form-data: class=Math&auth=GRJWLFJM7V or auth=6MVCV8XE46)
```

## Connecting to Mongo db

Port 27017 is exposed. So just connect to localhost:27017 with you favourite mongo client.

Database is named students.

## Stopping

```
docker-compose down
```

## Authors

* **Vojko Drev** - *Initial work* - (vojkodrev@gmail.com)
