-- # Write your MySQL query statement below
-- Inner query finds the second highest salary.

-- If it does not exist → MySQL returns NULL.

-- Outer SELECT ensures one row is always returned.

SELECT(
SELECT DISTINCT salary 
FROM Employee
ORDER BY salary DESC
LIMIT 1 OFFSET 1
)
AS 
SecondHighestSalary;