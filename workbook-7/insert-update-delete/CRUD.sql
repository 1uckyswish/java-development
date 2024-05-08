/*
1.
INSERT INTO northwind.Suppliers (
    SupplierID,
    CompanyName,
    ContactName,
    ContactTitle,
    Address,
    City,
    Region,
    PostalCode,
    Country,
    Phone,
    Fax,
    HomePage
) 
VALUES (
    NULL,
    'Hippo',
    'Noel',
    'Manager',
    '123 Supplier Address',
    'Supplier City',
    'Supplier Region',
    '12345', 
    'Hipnation',
    '123-456-7890',
    '123-456-7890',
    'http://www.supplierhomepage.com'
);


2.
INSERT INTO northwind.Products (
    ProductID,
    ProductName,
    SupplierID,
    CategoryID,
    QuantityPerUnit,
    UnitPrice,
    UnitsInStock,
    UnitsOnOrder,
    ReorderLevel,
    Discontinued
) 
VALUES (
    NULL,
    'New Product Name',
    30,
    1,
    '1 unit per box',
    10.00,
    100,
    0,
    10,
    0
);

3.
SELECT 
    P.ProductName,
    S.CompanyName
FROM 
    northwind.Products AS P
JOIN 
    northwind.Suppliers AS S
ON 
    P.SupplierID = S.SupplierID;

4.
SET SQL_SAFE_UPDATES=0;
UPDATE Products
SET UnitPrice = (UnitPrice + 1.50)
WHERE ProductID = 78;
SET SQL_SAFE_UPDATES=1;

5.
SELECT 
    P.ProductName,
    P.UnitPrice
FROM 
    northwind.Products AS P
JOIN 
    northwind.Suppliers AS S
ON 
    P.SupplierID = S.SupplierID
WHERE 
	S.CompanyName = 'Hippo';


6.
SET SQL_SAFE_UPDATES=0;
DELETE FROM Products
WHERE ProductID = 78;

7.
DELETE FROM Suppliers
WHERE SupplierID = 30;

8.
SELECT * FROM northwind.Products;

9.
SELECT * FROM northwind.Suppliers;











*/