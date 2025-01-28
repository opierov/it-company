USE it_company_db;

INSERT INTO offices (location, capacity) VALUES
('New York', '200'),
('Los Angeles', '150');
('Chicago', '100');

INSERT INTO companies (name, staff, revenue, offices_id, departments_id) VALUES
('Tech Corp', '50', '5M', 1, 1),
('Innovate Inc', '75', '7M', 2, 2);
('Future Tech', '120', '10M', 3, 1);

INSERT INTO departments (name, specialization, directors_id, teams_id) VALUES
('Software Development', 'AI', 1, 1),
('Marketing', 'Digital Campaigns', 2, 2);
('Finance', 'Accounting', 1, 2);

INSERT INTO directors (first_name, last_name, salary, region) VALUES
('Alice', 'Smith', '150000', 'North America'),
('Bob', 'Johnson', '120000', 'Europe');

INSERT INTO teams (name, cost, work_hours, consultants_id, employees_id) VALUES
('AI Research', '500K', '40', 1, 1),
('Digital Ads', '300K', '35', 2, 2);

INSERT INTO managers (first_name, last_name, salary, industry, skills) VALUES
('Eve', 'Taylor', '100000', 'Software', 'Leadership, Java'),
('Mark', 'Brown', '95000', 'Marketing', 'SEO, Analytics');
('Tom', 'Hardy', '105000', 'Finance', 'Taxation');

INSERT INTO employees (first_name, last_name, role, salary, managers_id) VALUES
('John', 'Doe', 'Developer', '75000', 1),
('Sarah', 'Connor', 'Analyst', '65000', 2);
('Paul', 'Walker', 'Accountant', '70000', 3);

INSERT INTO consultants (first_name, last_name, salary, industry, managers_id) VALUES
('James', 'Bond', '85000', 'Cybersecurity', 1),
('Anna', 'White', '78000', 'Data Science', 2);
('Emma', 'Stone', '80000', 'Finance', 3);

INSERT INTO employee_projects (employees_id, projects_id) VALUES
(1, 1),
(2, 2);

INSERT INTO consultant_projects (consultants_id, projects_id) VALUES
(1, 1),
(2, 2);

INSERT INTO project (name, deadline, budget, technology) VALUES
('AI Platform', '2025-06-30', '1M', 1),
('Marketing Automation', '2025-03-15', '800K', 2);
('Finance Tracker', '2025-12-31', '500K', 3);

INSERT INTO client (name, contact_info, first_name, last_name, projects_id) VALUES
('Global Tech', 'info@globaltech.com', 'Elon', 'Musk', 1),
('Ad Innovators', 'contact@adinno.com', 'Jeff', 'Bezos', 2);
('Finance Solutions', 'info@financesol.com', 'Mary', 'Jane', 3);