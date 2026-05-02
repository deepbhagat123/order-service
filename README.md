# Order Service — SmartCart Microservices

Part of the SmartCart retail backend system, inspired by Walmart's order management architecture.

## Overview
Order Service handles order placement and order history. It communicates with Product Service to validate stock before confirming any order.

## Tech Stack
- Java 17
- Spring Boot 3.5
- Spring Data JPA / Hibernate
- MySQL 9.6
- Resilience4j (Circuit Breaker)
- Maven

## Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /orders?productId=&quantity= | Place a new order |
| GET | /orders | Retrieve all orders |

## Architecture
- Runs on port 8082
- Database: smartcart_orders
- Calls Product Service (port 8081) via RestTemplate to validate stock
- Circuit breaker pattern implemented — if Product Service is down, returns graceful fallback instead of crashing

## How to Run
1. Make sure MySQL is running and smartcart_orders database exists
2. Start Product Service on port 8081 first
3. Run OrderServiceApplication.java
4. Test via Postman

## Related Repo
- [Product Service](https://github.com/deepbhagat123/smartcart-api)
