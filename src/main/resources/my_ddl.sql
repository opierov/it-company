CREATE DATABASE IF NOT EXISTS it_company_db;
USE it_company_db

CREATE TABLE IF NOT EXISTS offices (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    location VARCHAR(45) NOT NULL,
    capacity VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS companies (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    staff VARCHAR(45) NOT NULL,
    revenue VARCHAR(45) NOT NULL,
    offices_id BIGINT NOT NULL UNSIGNED,
    departments_id BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (id),
    CONSTRAINT fk_companies_offices FOREIGN KEY (offices_id)
    REFERENCES offices (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_companies_departments FOREIGN KEY (departments_id)
    REFERENCES departments (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS departments (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    specialization VARCHAR(45) NOT NULL,
    directors_id BIGINT NOT NULL UNSIGNED,
    teams_id BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (id),
    CONSTRAINT fk_department_directors FOREIGN KEY (directors_id)
    REFERENCES directors (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_department_teams FOREIGN KEY (teams_id)
    REFERENCES teams (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS directors (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    salary VARCHAR(45) NOT NULL,
    region VARCHAR(45) NOT NULL
    );

CREATE TABLE IF NOT EXISTS teams (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    cost VARCHAR(45) NOT NULL,
    work_hours VARCHAR(45) NOT NULL,
    consultants_id BIGINT NOT NULL UNSIGNED,
    employees_id BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (id),
    CONSTRAINT fk_teams_consultants FOREIGN KEY (consultants_id)
    REFERENCES consultants (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_teams_employees FOREIGN KEY (employees_id)
    REFERENCES employees (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS managers (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    salary VARCHAR(45) NOT NULL,
    industry VARCHAR(45) NOT NULL,
    skills VARCHAR(45) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS employees (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    role VARCHAR(45) NOT NULL,
    salary VARCHAR(45) NOT NULL,
    managers_id BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (id),
    CONSTRAINT fk_employees_managers FOREIGN KEY (managers_id)
    REFERENCES managers (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS consultants (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    salary VARCHAR(45) NOT NULL,
    industry VARCHAR(45) NOT NULL,
    managers_id BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (id),
    CONSTRAINT fk_consultants_managers FOREIGN KEY (managers_id)
    REFERENCES managers (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS employee_projects (
    employees_id BIGINT NOT NULL UNSIGNED,
    projects_id BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (employees_id, projects_id),
    CONSTRAINT fk_employee_projects_employees FOREIGN KEY (employees_id)
    REFERENCES employees (id),
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_employee_projects_projects FOREIGN KEY (projects_id)
    REFERENCES projects (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS consultant_projects (
    consultants_id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    projects_id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    PRIMARY KEY (consultants_id, projects_id),
    CONSTRAINT fk_consultant_projects_consultants FOREIGN KEY (consultants_id)
    REFERENCES consultants (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk_consultant_projects_projects FOREIGN KEY (projects_id)
    REFERENCES projects (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );

CREATE TABLE IF NOT EXISTS project (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    deadline VARCHAR(45) NOT NULL,
    budget VARCHAR(45) NOT NULL,
    technology BIGINT NOT NULL UNSIGNED,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS client (
    id BIGINT NOT NULL UNSIGNED AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    contact_info VARCHAR(45) NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    projects_id VARCHAR(45) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_client_projects FOREIGN KEY (projects_id)
    REFERENCES projects (id)
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
    );