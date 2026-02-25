# Write your MySQL query statement below
-- SELECT eu.unique_id, name
-- FROM Employees e
-- LEFT JOIN 
-- EmployeeUni eu
-- ON e.id= eu.id;


SELECT eu.unique_id AS unique_id, 
e.name AS name
FROM Employees e
LEFT JOIN 
EmployeeUni eu
ON e.id= eu.id;