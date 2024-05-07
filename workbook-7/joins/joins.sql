/*
1. 
SELECT 
    Products.ProductID, 
    Products.ProductName, 
    Products.UnitPrice, 
    Categories.CategoryName 
FROM 
    northwind.Products 
JOIN 
    northwind.Categories 
ON 
    Products.CategoryID = Categories.CategoryID 
ORDER BY 
    Categories.CategoryName, 
    Products.ProductName;



2. 
SELECT 
    Products.ProductID, 
    Products.ProductName, 
    Products.UnitPrice,
    Suppliers.CompanyName
FROM
    northwind.Products
JOIN
    northwind.Suppliers
ON
    Products.SupplierID = Suppliers.SupplierID
WHERE
    Products.UnitPrice >= 75
ORDER BY
    Products.ProductName;

3.
SELECT 
    Products.ProductID, 
    Products.ProductName, 
    Products.UnitPrice,
    Categories.CategoryName,
    Suppliers.CompanyName
FROM
    northwind.Products
JOIN
    northwind.Suppliers
ON
    Products.SupplierID = Suppliers.SupplierID
JOIN northwind.Categories
ON
Products.CategoryID = Categories.CategoryID
WHERE
    Products.UnitPrice >= 75
ORDER BY
    Products.ProductName;

4.
SELECT 
    Product.ProductName,
    Categories.CategoryName
FROM 
    northwind.Products AS Product
JOIN
    northwind.Categories AS Categories
ON
    Product.CategoryID = Categories.CategoryID 
WHERE 
    Product.UnitPrice = (
        SELECT MAX(UnitPrice) 
        FROM northwind.Products AS P
        WHERE P.CategoryID = Product.CategoryID
    )
ORDER BY 
    Product.ProductName;

5.

SELECT 
    O.OrderID,
    O.ShipName,
    O.ShipAddress,
    S.CompanyName,
    O.ShipCountry
FROM 
    northwind.Orders AS O
JOIN 
    northwind.Suppliers AS S
ON 
    O.ShipVia = S.SupplierID
WHERE 
    O.ShipCountry = 'Germany';


6.
SELECT 
    O.OrderID,
    O.OrderDate,
    O.ShipName,
    O.ShipAddress
FROM 
    northwind.Orders AS O
JOIN 
    northwind.`Order Details` AS OD
ON 
    O.OrderID = OD.OrderID
JOIN 
    northwind.Products AS P
ON 
    OD.ProductID = P.ProductID
WHERE 
    P.ProductName = 'Sasquatch Ale';


*/