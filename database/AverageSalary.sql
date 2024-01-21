--Write a SQL query to print department name along with department wise average salary. The average salary should be rounded to 2 decimal places.
--
--Output Schema:
--
--department_name,average_salary
--NOTE: Output column name has to match the given output schema.
--
--Example Output:
--
--department_name,average_salary
--IT,15500
--Schema Design:
--
--Schema Description

SELECT d.deptname as department_name,round(avg(e.salary),2) as average_salary
from employee as e join department as d using(deptid)
group by deptid;
