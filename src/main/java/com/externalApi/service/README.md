# Loan Account API

Spring Boot REST API that integrates with an external loan service,
derives due EMI details, persists data, and exposes a clean response.

## Tech Stack
- Java 21
- Spring Boot
- Maven
- H2 Database

## API Endpoint
GET /loan/{loanAccountNumber}

### Sample Response
```json
{
  "loanAccountNumber": "1",
  "dueDate": "2024-04-15",
  "emiAmount": 10000
}
