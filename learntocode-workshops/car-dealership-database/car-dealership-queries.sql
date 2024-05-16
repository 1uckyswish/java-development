USE dealership;

-- 1 GET ALL DEALERSHIPS

SELECT * FROM dealerships;

-- 2 FIND ALL VEHICLES FOR A SPECIFIC DEALERSHIP

SELECT
	V.*
FROM 
	vehicle AS V
JOIN 
	inventory AS I
ON 
	V.vin = I.vin
WHERE 
	I.dealership_id = 1;
	
-- 3 FIND A CAR BY VIN

SELECT 
	V.* 
FROM 
	vehicle AS V
WHERE
	V.vin = 567890;

-- 4 Find the dealership where a certain car is located by vin

SELECT 
	D.*
FROM 
	dealerships AS D
JOIN 
	inventory AS I
ON D.dealership_id = I.dealership_id
JOIN
	vehicle AS V
ON 
	V.vin = I.vin
WHERE 
	V.type = 678901;

-- 5 FIND ALL DEALERSHIPS THAT HAVE A CERTAIN CAR TYPE

SELECT 
	D.*
FROM 
	dealerships AS D
JOIN 
	inventory AS I
ON D.dealership_id = I.dealership_id
JOIN
	vehicle AS V
ON 
	V.vin = I.vin
WHERE 
	V.type = 'sedan';

-- 6 GET ALL SALES INFORMATION FOR A SPECIFIC DEALER FOR SPECIFIC DATE RANGE

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
