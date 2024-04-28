# Inventory Management System

This is a backend application for managing inventory.

## Setup

1. Clone the repository.
2. Configure database connection in `application.properties`.
3. Run the application using `mvn spring-boot:run`.

## API Documentation

### Endpoints

- **POST** `/inventory/addInventory`: Add quantity to an existing inventory item.
- **POST** `/inventory/deductInventory`: Deduct quantity from an existing inventory item.

## Testing

Unit tests are provided for controller and service classes to verify functionality and ensure reliability.

## Logging

Logging configuration can be added using logging frameworks like Log4j or Logback.

## Security

Security measures such as authentication and authorization can be implemented using Spring Security.

## Performance Optimization

Performance can be optimized through caching, database query optimization, and resource usage monitoring.


