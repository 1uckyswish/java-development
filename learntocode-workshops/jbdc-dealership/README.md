# Advanced Java Car Dealership with MySQL Integration

## Project Overview

Welcome to the Advanced Java Car Dealership project! This project is aimed at streamlining the management of a car dealership through a Java-based application. With the recent integration of MySQL, the application now offers enhanced data management capabilities and scalability.

## Project Setup

1. **Maven Project Initialization**:
   - Created a new Maven project in IntelliJ IDEA.
   - Added dependencies including MySQL Driver and `BasicDataSource` in the `pom.xml` file.

2. **Database Configuration**:
   - Installed and configured MySQL on my system.
   - Created a MySQL database named `CarDealership`.
   - Executed the provided database script to set up required tables (`vehicles`, `sales_contracts`, `lease_contracts`).

3. **Model Modifications**:
   - Modified existing models (Dealership, Vehicle, SalesContract, LeaseContract) to include an `id` field for database compatibility.

## Persistence Logic

- Replaced FileManager class with DataManager classes for CRUD operations interacting with MySQL.
- Organized DataManager or DAO classes for each database table (vehicles, sales_contracts, lease_contracts) for better modularity.

## Application Flow

- Ensured continuity in application flow from Workshop 5, now interacting with MySQL instead of CSV files.
- All functionalities on the dealership home screen fetch or update data from MySQL.

## Sale vs Lease

- Implemented logic to store sales contract data in `sales_contracts` table and lease contract data in `lease_contracts` table.

## Main Class (Home)

This is the heart of our Java Car Dealership project. The Main class manages all store functionalities. Check out the Maven Java folder structure on the left to see how the project is organized.

![Screenshot 2024-05-13 at 3 40 36 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/5c899e37-7747-46cc-be05-3987b4757ac5)

## Phases of Development

### Phase 1: Vehicle Search Functionality

- Created VehicleDao and implemented methods to search the database for vehicles based on various criteria.

![Screenshot 2024-05-13 at 3 42 09 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/b98ec13d-727a-4606-aa77-3841bbb2fff1)
![Screenshot 2024-05-13 at 3 42 42 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/89737081-9539-44fd-80d4-b3b1eb955724)
![Screenshot 2024-05-13 at 3 43 03 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/5b313a1a-8090-4aba-9a90-7ea022510119)
![Screenshot 2024-05-13 at 3 45 16 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/491db340-30b6-4012-8197-6b2b66390479)


### Phase 2: Add/Remove Vehicles

- Successfully implemented functionality to add and remove vehicles from the database.

![Screenshot 2024-05-13 at 3 47 07 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/a515d71e-a495-4f29-b9e2-02c6bd2c6b1d)
![Screenshot 2024-05-13 at 3 47 21 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/ab88a2e0-50ae-4148-95a6-bab614993293)
![Screenshot 2024-05-13 at 3 47 54 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/69b9340d-23f6-4011-af6a-e5975154050f)
![Screenshot 2024-05-13 at 3 47 58 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/f85c2545-f11a-44d0-90a3-21a972b455df)

### Phase 3: Sales and Lease Management

- Developed SalesDao and LeaseDao classes.
- Updated dealership logic to save sales/lease information to the respective database tables.

![Screenshot 2024-05-13 at 3 48 55 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/da4a247a-ba97-4997-8f4a-6431aa133313)
![Screenshot 2024-05-13 at 3 49 06 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/a7abc6db-9af2-4b53-b454-d842b4d277ce)
![Screenshot 2024-05-13 at 3 49 27 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/6d08d9c1-482a-4033-866d-d3b8eaf7caed)
![Screenshot 2024-05-13 at 3 49 31 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/3429b964-7c8a-4e98-9072-f9aac9d23f57)


## Cleanup

- Removed all .csv files from the project.
- Verified project functionality after transitioning to MySQL.

<img width="1440" alt="Screenshot 2024-05-13 at 3 52 32 PM" src="https://github.com/1uckyswish/jbdc-dealership/assets/107442415/9027120b-80e4-4426-b243-193aed4c80b3">
<img width="1440" alt="Screenshot 2024-05-13 at 3 52 06 PM" src="https://github.com/1uckyswish/jbdc-dealership/assets/107442415/36a54940-459d-46a4-87a8-8840e51c87a2">
<img width="1440" alt="Screenshot 2024-05-13 at 3 52 12 PM" src="https://github.com/1uckyswish/jbdc-dealership/assets/107442415/0305dc44-0672-455d-a01c-8ffc2ab9cd48">
<img width="1440" alt="Screenshot 2024-05-13 at 3 52 19 PM" src="https://github.com/1uckyswish/jbdc-dealership/assets/107442415/0840e542-7a95-41a7-99e7-6f35fc851c7e">

## Bonus Ideas

- Explored enhancing the AdminUser interface to retrieve sales and lease information from the database for comprehensive reporting and management capabilities.

![Screenshot 2024-05-13 at 3 50 22 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/c535a090-8cb2-49c1-b9eb-d1d7cab6a0b5)
![Screenshot 2024-05-13 at 3 50 31 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/75454865-381a-4feb-baee-c241c79cbd18)


## Interesting Section of code

The application's main class, Program, orchestrates the initialization of the database connection and the user interface. Here's a snippet showcasing its simplicity and clarity:

![Screenshot 2024-05-13 at 3 57 48 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/560678c2-3910-4c05-8dd9-81fbcc04caee)
![Screenshot 2024-05-13 at 3 57 55 PM](https://github.com/1uckyswish/jbdc-dealership/assets/107442415/88892830-148a-472c-8bf2-8a57ad819787)


This elegant design encapsulates database operations and user interaction seamlessly, ensuring a smooth and efficient user experience.

