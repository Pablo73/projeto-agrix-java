# Agrix - Fertilizer and Crop Management Application #
Agrix is a fertilizer and crop management application that allows farmers and agronomists to record information about fertilizers, crops, and their associations. This application was developed with the aim of simplifying the agricultural resource management process.

## Main Features ##
- **Fertilizer Registration:** Record detailed information about fertilizers, including name, brand, and composition.
- **Crop Registration:** Record information about crops, such as name, planted area, planting date, and harvest date.
- **Association of Fertilizers with Crops:** Associate specific fertilizers with crops to track fertilizer usage in each crop.
- **User Authentication:** Users can authenticate in the application to access authentication-protected features.

# Technologies Used #
- **Spring Boot:** The backend of the application is developed in Java with the Spring Boot framework, providing a robust development environment.
- **Spring Security:** Spring Security is used to handle user authentication and authorization.
- **JWT (JSON Web Tokens):** JWT is used to generate secure authentication tokens.
- **Hibernate:** Hibernate is used to map Java objects to the relational database.
- **H2 Database:** The H2 Database is used to store data in testing.
- **Maven:** Maven is used to manage project dependencies.
- **BCrypt:** All user passwords are securely stored using encryption.
- **PostgreSQL Database:** Agrix uses the PostgreSQL database to store all information related to crops, fertilizers, and users.

# Development Environment Setup #
To set up and run the project in a local development environment, follow the steps below:
Clone this repository to your local environment:
```bash
git clone https://github.com/your-username/agrix.git
```
Navigate to the project directory:
```bash
cd agrix
```
Run the project using Maven:
```bash
./mvnw spring-boot:run
```
  
