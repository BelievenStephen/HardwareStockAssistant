# Tech Central Inventory Management System

## Description
This project is an inventory management system for "Tech Central," a fictitious store specializing in tech products. It's built using Spring Boot and Thymeleaf for the web interface. The system manages parts and products, allowing users to add, update, delete, and purchase products through a web interface.

## Features
- **Product Management**: Add, update, and delete products.
- **Part Management**: Add, update, and delete parts.
- **Purchase Products**: Products can be purchased via a "Buy Now" button, which decrements the product's inventory count.
- **Search Functionality**: Users can search for parts and products based on keywords.
- **Error Handling**: Display messages indicating the success or failure of operations, particularly in purchasing products.

## Technical Overview
- **Frameworks/Libraries**: Spring Boot, Thymeleaf, Spring Data JPA.
- **Database**: H2 Database for development.
- **Frontend**: Thymeleaf templates styled with Bootstrap.

## Project Structure
- `src/main/java/com/example/demo` - Contains the source code including controllers, services, repositories, and entities.
- `src/main/resources/templates` - Contains Thymeleaf HTML templates for the user interface.
- `src/main/resources/static` - Contains static assets like CSS files and JavaScript.
- `src/test` - Contains unit tests for the application.

## Setup and Installation
1. **Clone the repository**:
   ```bash
   git clone [repository-url]
