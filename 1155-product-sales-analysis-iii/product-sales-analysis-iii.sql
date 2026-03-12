# Write your MySQL query statement below
SELECT product_id, quantity, price,
year AS first_year
FROM Sales
WHERE (product_id, year) IN (
    SELECT product_id, MIN(year)
    FROM Sales
    GROUP BY product_id
);

