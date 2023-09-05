# Agrix - Fertilizer and Crop Management Application #
Agrix is a fertilizer and crop management application that allows farmers and agronomists to record information about fertilizers, crops, and their associations. This application was developed with the aim of simplifying the agricultural resource management process.

## Main Features ##
- **Fertilizer Registration:** Record detailed information about fertilizers, including name, brand, and composition.
- **Crop Registration:** Record information about crops, such as name, planted area, planting date, and harvest date.
- **Association of Fertilizers with Crops:** Associate specific fertilizers with crops to track fertilizer usage in each crop.
- **User Authentication:** Users can authenticate in the application to access authentication-protected features.

## Technologies Used ##
- **Spring Boot:** The backend of the application is developed in Java with the Spring Boot framework, providing a robust development environment.
- **Spring Security:** Spring Security is used to handle user authentication and authorization.
- **JWT (JSON Web Tokens):** JWT is used to generate secure authentication tokens.
- **Hibernate:** Hibernate is used to map Java objects to the relational database.
- **H2 Database:** The H2 Database is used to store data in testing.
- **Maven:** Maven is used to manage project dependencies.
- **BCrypt:** All user passwords are securely stored using encryption.
- **PostgreSQL Database:** Agrix uses the PostgreSQL database to store all information related to crops, fertilizers, and users.

## Development Environment Setup ##
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
## Deployment ##
The Agrix application has been deployed on the Fly.io platform and is available at the following link: https://wild-surf-9544.fly.dev

## API Routes ##
Here are the main routes of the Agrix API, along with a brief explanation of each:

1. User Registration: **(POST /persons)**
- Allows the registration of new users, including information such as username and password.
- **Example request:**
```bash
{
  "username": "Doutor Manhattan",
  "password": "senhasecreta",
  "role": "ADMIN"
}
```

2. User Authentication: **(POST /auth/login)**
- Allows users to log in to the application by providing a username and password. Returns a valid authentication token.
-  **Example request:**
```bash
{
  "username": "Doctor Manhattan",
  "password": "secretpassword"
}
```

3. Farm Registration: **(POST /farms)**
- Allows the registration of a new farm, providing information such as name and size.
-  **Example request:**
```bash
{
  "name": "Radioactive particle farm",
  "size": 5
}
```

4. Fertilizer Registration: **(POST /fertilizers)**
- Allows the registration of new fertilizers, providing information such as name, brand, and composition.
-  **Example request:**
```bash
{
  "name": "Composting",
  "brand": "Made at the hadron collider",
  "composition": "particulate matter"
}
```

5. Crop Details: **(POST /farms/{farmId}/crops)**
- Allows the registration of a new crop, associating it with a farm.
-  **Example request:**
```bash
{
  "name": "Radioactive cauliflower",
  "plantedArea": 5.43,
  "plantedDate": "2022-12-05",
  "harvestDate": "2023-06-08"
}
```

6. Association of Fertilizers with Crops: **(POST /crops/{cropId}/fertilizers/{fertilizerId})**
- Associates a specific fertilizer with a crop, allowing the tracking of fertilizer usage in each crop.

7. **(GET /farms)** - Get List of Farms.
9. **(GET /farms/{id})** - Get a Farm by ID.
11. **(GET /farms/{farmId}/crops)** - Get a Farm by ID and Associated Crops.
12. **(GET /crops)** - Get a List of All Crops.
13. **(GET /crops/{id})** - Get a Crop by ID.
14. **(GET /crops/search)** - Perform a Search or Query in the System for Specific Agricultural Crop Information.
15. **(GET /fertilizers)** - Get a List of All Fertilizers.
16. **(GET /fertilizers/{id})** - Get a Fertilizer by ID.
17. **(GET /crops/{cropId}/fertilizers)** - Get a Crop by ID and Its Fertilizer Relationship.





  
