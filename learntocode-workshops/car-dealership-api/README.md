# Car Dealership API with Spring Boot and MySQL Integration

## Project Overview

Welcome to the Car Dealership API project! This project aims to convert a command-line interface (CLI) application into a RESTful web-based API using Java Spring Boot and MySQL. With this transformation, the application gains enhanced accessibility and scalability.

## Project Setup

1. **Spring Boot Project Initialization**:
   - Created a new Maven project using Spring Initializr.
   - Added dependencies including Spring Web and MySQL Driver in the `pom.xml` file.

2. **Database Configuration**:
   - Set up MySQL database connection using `application.properties`.
   - Created a `DatabaseConfiguration` class to create a `BasicDataSource` bean for database connection.

3. **Porting Existing Functionality**:
   - Transferred existing models and database DAO classes from previous workshops.
   - Ensured compatibility with Spring framework.

## Dependency Injection

- Configured `application.properties` for database connection string.
- Implemented `DatabaseConfiguration` class to create a `BasicDataSource` bean.
- Annotated JDBC data access objects with `@Component` annotation for dependency injection.

## Adding Controllers

- Developed controllers to handle HTTP requests and interact with the database.
- Implemented CRUD operations for Vehicles, SalesContracts, and LeaseContracts.

## VehiclesController

- Implemented GET method with query string parameters for vehicle filtering.
- Added POST method for adding a new vehicle.
- Included PUT method for updating vehicle information.
- Created DELETE method for deleting a vehicle.

## SalesContractsController

- Created GET method to retrieve a sales contract by its ID.
- Implemented POST method for adding a new sales contract to the database.

## LeaseContractsController

- Developed GET method to fetch a lease contract by its ID.
- Added POST method for adding a new lease contract to the database.

## Project Structure

The project is structured as follows:
![Screenshot 2024-05-16 at 2 21 48 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/ca2e5015-cbc6-4ea3-a829-1290473e3e50)


### Database Configuration
- **Database Configuration Overview**: Instructions for setting up the MySQL database connection.
 ![Screenshot 2024-05-16 at 2 30 25 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/b754f98a-70e1-4465-a194-9a740ee90ad9)


### DAOs (Data Access Objects)
- **VehicleDao**: Responsible for managing vehicle data in the database.

![Screenshot 2024-05-16 at 2 32 11 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/1d91d597-1ff1-44f3-94c2-4d643e054dcf)

- **SalesContractDao**: Handles sales contract data in the database.

![Screenshot 2024-05-16 at 2 32 47 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/75d05ed3-c556-46c2-b4a6-69358a97ed5a)
 
- **LeaseContractDao**: Manages lease contract data in the database.

![Screenshot 2024-05-16 at 2 33 00 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/282c3e00-78d0-4471-b4bb-98644100358d)


### Controllers
- **Default Controller**: Handles default endpoints and routing.
![Screenshot 2024-05-16 at 2 55 45 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/d43cfb6f-27e3-43c8-9b19-451f0348f572)

 
- **Lease Contract Controller**: Manages endpoints related to lease contracts.
![Screenshot 2024-05-16 at 2 55 54 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/a84cedc3-91f6-4cbd-aa19-ddc266745818)

 
- **Sales Contract Controller**: Handles endpoints for sales contracts.
![Screenshot 2024-05-16 at 2 56 29 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/8286d7b7-59b8-4ad9-8908-f5cc69718fd4)



### Postman Scripts
- **GET**: Postman scripts for testing GET requests.
![Screenshot 2024-05-16 at 2 58 30 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/6481fa2a-74a7-4683-adaa-2b29fb81eeab)

 
- **POST**: Postman scripts for testing POST requests.
![Screenshot 2024-05-16 at 2 59 56 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/405583b9-aed1-40bc-92e7-c449af823c0d)


- **PUT**: Postman scripts for testing PUT requests.
![Screenshot 2024-05-16 at 3 01 22 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/67a42eee-8d1c-4872-8117-ad39b5615e89)


- **DELETE**: Postman scripts for testing DELETE requests.


![Screenshot 2024-05-16 at 3 01 38 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/3a3fddc5-cdf4-4865-88ff-87d25a8dd64b)


## Interesting Piece of Code

### Utility Method for Vehicle Object Creation

The following code is an interesting piece from our project. It demonstrates a utility method that converts a `ResultSet` from a MySQL query into a `Vehicle` object. This method is part of the `VehicleUtils` class and significantly improves the readability and maintainability of our code by encapsulating the logic required to map database columns to a `Vehicle` object.

![Screenshot 2024-05-16 at 3 15 07 PM](https://github.com/1uckyswish/car-dealership-api/assets/107442415/07f8a282-d0cb-41cc-8076-3ef56ffcf2f7)


