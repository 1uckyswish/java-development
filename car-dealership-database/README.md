# Car Dealership Database

This project is a SQL script aiming to create a comprehensive car dealership database, complete with initial data. It covers tables for dealerships, vehicles, inventory, sales contracts, and lease contracts, providing a solution for managing all aspects of dealership operations.

## Database Schema

The database schema consists of the following tables:

- **dealerships**: Stores information about car dealerships such as name, address, and phone number.
- **vehicle**: Contains details about vehicles including VIN, year, make, model, type, color, odometer reading, price, and sold status.
- **inventory**: Tracks which vehicles are available at which dealerships.
- **sales_contracts**: Stores information about vehicle sales contracts.
- **lease_contracts**: Records details of vehicle lease contracts.

## Sample Queries

This project includes sample SQL queries to perform various operations on the database. Here are some examples:

1. **Get all dealerships**: Retrieve a list of all dealerships from the database.
2. **Find all vehicles for a specific dealership**: Retrieve all vehicles available at a particular dealership.
3. **Find a car by VIN**: Search for a vehicle using its Vehicle Identification Number (VIN).
4. **Find the dealership where a certain car is located by VIN**: Determine the dealership where a specific vehicle is currently located.
5. **Find all dealerships that have a certain car type**: Identify all dealerships that have a particular type of car available in their inventory.
6. **Get all sales information for a specific dealer for a specific date range**: Retrieve sales information for a particular dealership within a specified date range.

## Queries for Testing

For testing purposes, sample SQL queries have been provided in separate files to verify that the database has been created and populated correctly. Each query corresponds to a specific test case and can be executed individually.

## One Interesting Query

```sql
SELECT 
	D.*
FROM 
	dealerships AS D
JOIN 
	inventory AS I
ON 
	D.dealership_id = I.dealership_id
JOIN
	vehicle AS V
ON 
	V.vin = I.vin
JOIN
	sales_contracts AS SC
ON
	V.vin = SC.vin
WHERE
	D.dealership_id = 2;
```
