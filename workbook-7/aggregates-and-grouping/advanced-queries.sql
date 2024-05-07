/*
1. SELECT COUNT(*) FROM northwind.Suppliers;
2. SELECT SUM(Salary) FROM northwind.Employees;
3. SELECT MIN(UnitPrice) FROM northwind.Products;
4. SELECT AVG(UnitPrice) FROM northwind.Products;
5. SELECT MAX(UnitPrice) FROM northwind.Products;
6. SELECT SupplierID, COUNT(*) AS supplies FROM northwind.Products GROUP BY SupplierID;
7. SELECT CategoryID, AVG(UnitPrice) as AVERAGE FROM northwind.Products GROUP BY CategoryID;
8. SELECT SupplierID, COUNT(*) AS supplies FROM northwind.Products GROUP BY SupplierID HAVING COUNT(*) >= 5;
9. SELECT ProductID, ProductName, UnitPrice * UnitsInStock AS InventoryValue FROM northwind.Products ORDER BY InventoryValue DESC, ProductName;
*/




/* 
SELECT SupplierID, COUNT(*) AS supplies: 
This part specifies the columns you want to retrieve in your result set. 
You're selecting the SupplierID column, which represents the ID of each supplier, 
and the count of items supplied by each supplier.
*/
SELECT SupplierID, COUNT(*) AS supplies

/* 
FROM northwind.Products: 
This part specifies the table from which you're selecting data. 
You're selecting data from the Products table in the northwind database.
*/
FROM northwind.Products

/* 
GROUP BY SupplierID: 
This part is crucial for grouping the data. 
You're grouping rows by the SupplierID column. 
This means that all rows with the same SupplierID will be grouped together.
*/
GROUP BY SupplierID

/* 
HAVING COUNT(*) >= 5: 
This part filters the grouped data. 
It specifies that only groups where the count of items (COUNT(*)) is greater than or equal to 5 
will be included in the result set. 
This filters out suppliers who provide less than 5 items.
*/
HAVING COUNT(*) >= 5;
