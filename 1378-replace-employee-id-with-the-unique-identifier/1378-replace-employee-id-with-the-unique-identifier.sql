# Write your MySQL query statement below
SELECT eu.unique_id, name
FROM Employees e
LEFT JOIN 
EmployeeUni eu
ON e.id= eu.id;
