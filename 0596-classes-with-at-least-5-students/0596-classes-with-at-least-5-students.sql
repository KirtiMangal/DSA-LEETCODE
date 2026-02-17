# Write your MySQL query statement below
-- SELECT DISTINCT c.class
-- FROM Courses c
-- WHERE c.class>5; 

SELECT class FROM courses
GROUP BY class
HAVING COUNT(*)>=5;