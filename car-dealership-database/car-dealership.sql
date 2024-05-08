-- Drop the database if it exists to ensure a clean slate
DROP DATABASE IF EXISTS dealership;

-- Create the dealership database if it doesn't exist and switch to it
CREATE DATABASE IF NOT EXISTS dealership;
USE dealership;

-- Create the 'dealerships' table to store information about car dealerships
CREATE TABLE `dealerships` (
    `dealership_id` INT AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each dealership
    `name` VARCHAR(100),   -- Name of the dealership
    `address` VARCHAR(100), -- Address of the dealership
    `phone` VARCHAR(20)     -- Phone number of the dealership
);

-- Create the 'vehicle' table to store information about vehicles
CREATE TABLE `vehicle` (
    `vin` INT PRIMARY KEY, -- Vehicle Identification Number (VIN), unique identifier for each vehicle
    `year` INT,            -- Year of manufacture
    `make` VARCHAR(50),    -- Make of the vehicle (e.g., Toyota, Honda)
    `model` VARCHAR(50),   -- Model of the vehicle (e.g., Camry, Civic)
    `type` VARCHAR(50),    -- Type of the vehicle (e.g., Sedan, Truck)
    `color` VARCHAR(50),   -- Color of the vehicle
    `odometer` INT,        -- Odometer reading (mileage) of the vehicle
    `price` DOUBLE,        -- Price of the vehicle
    `sold` VARCHAR(3)      -- Indicates whether the vehicle is sold or not (e.g., 'Yes', 'No')
);

-- Create the 'inventory' table to track which vehicles are available at which dealerships
CREATE TABLE `inventory` (
    `dealership_id` INT, -- Foreign key referencing 'dealerships' table
    `vin` INT,           -- Foreign key referencing 'vehicle' table
    PRIMARY KEY (`dealership_id`, `vin`), -- Composite primary key
    FOREIGN KEY (`dealership_id`) REFERENCES `dealerships` (`dealership_id`), -- Foreign key constraint
    FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`) -- Foreign key constraint
);

-- Create the 'sales_contracts' table to store information about vehicle sales contracts
CREATE TABLE `sales_contracts` (
    `sales_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each sales contract
    `vin` INT,                                          -- Foreign key referencing 'vehicle' table
    FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)    -- Foreign key constraint
);

-- Create the 'lease_contracts' table to store information about vehicle lease contracts
CREATE TABLE `lease_contracts` (
    `lease_id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY, -- Unique identifier for each lease contract
    `vin` INT,                                          -- Foreign key referencing 'vehicle' table
    FOREIGN KEY (`vin`) REFERENCES `vehicle` (`vin`)    -- Foreign key constraint
);

-- Insert sample data into the 'dealerships' table
INSERT INTO `dealerships`(`name`, `address`, `phone`)
VALUES
    ('Hippo Motors', '123 Hippo Ave, Hippo City, HP1234', '555-HIPPO-1234'),
    ('Piggy Motors','456 Piggy Lane, Piglet Town, PG5678','555-OINK-5678'),
    ('Gator Motors','789 Swamp Road, Gatorville, GA9012','555-SNAP-9012');

-- Insert sample data into the 'vehicle' table
INSERT INTO `vehicle`(`vin`, `year`, `make`, `model`, `type`, `color`, `odometer`, `price`, `sold`)
VALUES
    (123456, 2022, 'Toyota', 'Camry', 'Sedan', 'Blue', 5000, 25000, 'No'),
    (234567, 2021, 'Honda', 'Civic', 'Sedan', 'Red', 8000, 22000, 'No'),
    (345678, 2020, 'Ford', 'F-150', 'Truck', 'Black', 10000, 35000, 'Yes'),
    (456789, 2023, 'Tesla', 'Model Y', 'SUV', 'White', 2000, 60000, 'No'),
    (567890, 2022, 'Lamborghini', 'Aventador', 'Sports Car', 'Yellow', 100, 300000, 'No'),
    (678901, 2021, 'Porsche', '911', 'Coupe', 'Black', 5000, 100000, 'Yes');

-- Insert sample data into the 'inventory' table to track vehicle availability at dealerships
INSERT INTO `inventory`(`dealership_id`, `vin`)
VALUES
    (1, 123456),
    (1, 234567),
    (2, 345678),
    (2, 456789),
    (3, 567890),
    (3, 678901);

-- Insert sample data into the 'sales_contracts' table to record vehicle sales
INSERT INTO `sales_contracts`(`vin`)
VALUES
    (345678),
    (678901);
