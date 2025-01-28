USE it_company_db;

-- 10 DELETE statements
DELETE FROM employees WHERE id = 3;
DELETE FROM consultants WHERE id = 3;
DELETE FROM client WHERE id = 3;
DELETE FROM project WHERE id = 3;
DELETE FROM teams WHERE id = 3;
DELETE FROM departments WHERE id = 3;
DELETE FROM companies WHERE id = 3;
DELETE FROM offices WHERE id = 3;
DELETE FROM employee_projects WHERE employees_id = 2 AND projects_id = 1;
DELETE FROM consultant_projects WHERE consultants_id = 2 AND projects_id = 1;

-- 10 UPDATE statements
UPDATE employees SET salary = '80000' WHERE id = 1;
UPDATE consultants SET salary = '90000' WHERE id = 1;
UPDATE offices SET capacity = '250' WHERE id = 1;
UPDATE companies SET revenue = '6M' WHERE id = 1;
UPDATE departments SET specialization = 'AI and ML' WHERE id = 1;
UPDATE managers SET skills = 'Leadership, Java, AI' WHERE id = 1;
UPDATE teams SET cost = '550K' WHERE id = 1;
UPDATE project SET budget = '1.2M' WHERE id = 1;
UPDATE client SET contact_info = 'contact@globaltech.com' WHERE id = 1;
UPDATE employees SET role = 'Senior Developer' WHERE id = 1;

-- 5 ALTER TABLE statements
ALTER TABLE offices ADD COLUMN created_at DATETIME DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE companies MODIFY COLUMN staff INT NOT NULL;
ALTER TABLE employees ADD COLUMN date_of_hire DATE NULL;
ALTER TABLE consultants DROP COLUMN industry;
ALTER TABLE project ADD COLUMN description TEXT;

-- 1 big JOIN statement with at least 5 tables
SELECT
    e.first_name AS employee_name,
    m.first_name AS manager_name,
    c.name AS company_name,
    p.name AS project_name,
    cl.name AS client_name
FROM employees e
JOIN managers m ON e.managers_id = m.id
JOIN teams t ON e.id = t.employees_id
JOIN departments d ON t.id = d.teams_id
JOIN companies c ON d.id = c.departments_id
JOIN employee_projects ep ON e.id = ep.employees_id
JOIN project p ON ep.projects_id = p.id
JOIN client cl ON p.id = cl.projects_id;

-- Left JOIN
SELECT
    c.name AS company_name,
    o.location AS office_location
FROM companies c
LEFT JOIN offices o ON c.offices_id = o.id;

-- Right JOIN
SELECT
    e.first_name AS employee_name,
    m.first_name AS manager_name
FROM employees e
RIGHT JOIN managers m ON e.managers_id = m.id;

-- Inner JOIN
SELECT
    t.name AS team_name,
    d.name AS department_name
FROM teams t
INNER JOIN departments d ON t.id = d.teams_id;

-- Outer JOIN
SELECT
    e.first_name AS employee_name,
    m.first_name AS manager_name
FROM employees e
FULL OUTER JOIN managers m ON e.managers_id = m.id;

-- 5 statements with aggregation and GROUP BY
-- 1. Total number of employees per department
SELECT
    d.name AS department_name,
    COUNT(e.id) AS employee_count
FROM departments d
JOIN teams t ON d.id = t.teams_id
JOIN employees e ON t.id = e.team
GROUP BY d.name;

-- 2. Total budget per project
SELECT
    p.name AS project_name,
    SUM(p.budget) AS total_budget
FROM project p
GROUP BY p.name;

-- 3. Average salary by manager
SELECT
    m.first_name AS manager_name,
    AVG(e.salary) AS avg_salary
FROM managers m
JOIN employees e ON m.id = e.managers_id
GROUP BY m.id;

-- 4. Count of projects per client
SELECT
    cl.name AS client_name,
    COUNT(p.id) AS project_count
FROM client cl
JOIN project p ON cl.projects_id = p.id
GROUP BY cl.name
HAVING COUNT(p.id) > 1;

-- 5. Total revenue per company
SELECT
    c.name AS company_name,
    SUM(c.revenue) AS total_revenue
FROM companies c
GROUP BY c.name;