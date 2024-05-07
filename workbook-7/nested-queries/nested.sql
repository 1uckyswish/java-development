/*
1.SELECT Productname FROM northwind.Products WHERE UnitPrice IN (SELECT MAX(UnitPrice) FROM northwind.Products);
2.SELECT OrderID, ShipName, ShipAddress FROM northwind.Orders WHERE ShipVia = (SELECT ShipperID FROM northwind.Shippers WHERE CompanyName = 'Federal Shipping');
3.SELECT OrderID FROM northwind.`Order Details`WHERE ProductID = (SELECT ProductID FROM northwind.Products WHERE ProductName = 'Sasquatch Ale');
4.SELECT FirstName FROM northwind.Employees WHERE EmployeeID = (SELECT EmployeeID FROM northwind.Orders WHERE OrderID = 10266);
5.SELECT CompanyName FROM northwind.Customers WHERE CustomerID = (SELECT CustomerID FROM northwind.Orders WHERE OrderID = 10266);
*/