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


## API Documentation

## Base URL

http://localhost:8080


## Endpoints

## Deduct Inventory
Method: POST
Endpoint: /inventory/deduct
Request Body Format:
json
Copy code
{
"productId": "product_id",
"quantity": quantity
}
Response Format: Success message or error message
Transaction Validation Rules: Quantity to deduct must be positive and available in inventory.


## Add Inventory
Method: POST
Endpoint: /inventory/add
Request Body Format:
json
Copy code
{
"productId": "product_id",
"quantity": quantity
}
Response Format: Success message or error message
Transaction Validation Rules: Quantity to add must be positive.


## Error Handling


If the request is invalid or the transaction fails, appropriate error messages will be returned along with the corresponding HTTP status codes.



