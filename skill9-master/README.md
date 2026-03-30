# Student API - Global Exception Handling

## Run the application

```bash
mvn spring-boot:run
```

The app starts at `http://localhost:8080`.

## Endpoints

### 1) Valid student ID
`GET /student/1`

Sample response (`200 OK`):

```json
{
  "id": 1,
  "name": "Example",
  "department": "Computer Science"
}
```

### 2) Invalid student ID (not found)
`GET /student/999`

Sample response (`404 Not Found`):

```json
{
  "timestamp": "2026-03-04T12:34:56.123",
  "message": "Student not found for ID: 999",
  "statusCode": 404
}
```

### 3) Invalid input (negative/zero)
`GET /student/-5`

Sample response (`400 Bad Request`):

```json
{
  "timestamp": "2026-03-04T12:34:56.123",
  "message": "Student ID must be greater than 0.",
  "statusCode": 400
}
```

### 4) Invalid input format (text instead of number)
`GET /student/abc`

Sample response (`400 Bad Request`):

```json
{
  "timestamp": "2026-03-04T12:34:56.123",
  "message": "Student ID must be a valid number.",
  "statusCode": 400
}
```

## Postman testing

Import `student-api.postman_collection.json` into Postman and run all four requests.
