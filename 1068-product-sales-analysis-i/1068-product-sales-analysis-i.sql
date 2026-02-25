# Write your MySQL query statement below
-- SELECT product_name, year, price 
-- FROM Sales 
-- GROUP BY sales_id;

SELECT p.product_name, s.year, s.price
FROM Sales s
LEFT JOIN 
Product p
ON s.product_id = p.product_id;
