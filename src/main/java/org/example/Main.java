package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.*;
import org.example.services.*;
import org.example.services.impl.*;

import java.util.List;
import java.util.Optional;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {


        ClientService clientService = new ClientServiceImpl();
        ConsultantService consultantService = new ConsultantServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        ManagerService managerService = new ManagerServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();

        // USING CLIENT
        // 1. Add a new client
        Client client = new Client();
        clientService.add(client);
        logger.info("Client added: {}", client.getName());

        // 2. Get a client by ID
        Optional<Client> retrievedClient = clientService.getById(1L);
        retrievedClient.ifPresent(c -> logger.info("Client found: {}", c.getName()));

        // 3. Get all clients
        List<Client> allClients = clientService.getAll();
        allClients.forEach(c -> logger.info("Client: {}", c.getName()));

        // 4. Get clients by project
        List<Client> clientsByProject = clientService.getClientsByContactInfo("Test");
        clientsByProject.forEach(c -> logger.info("Client for Project: {}", c.getName()));

        // 5. Update client contact info
        clientService.updateClientContactInfo(1L, "newcontact@example.com");
        logger.info("Client contact info updated.");;

        // 6. Remove client by ID
        clientService.delete(1L);
        logger.info("Client removed.");

        // Using CONSULTANT
        // Add a new consultant
        Consultant consultant = new Consultant(1L, "John", "Doe", 5000D, "IT", new Manager(), List.of(new Project()));
        consultantService.add(consultant);

        // Get consultant by ID
        Optional<Consultant> retrievedConsultant = consultantService.getById(1L);
        retrievedConsultant.ifPresent(c -> logger.info("Consultant found: {}", c.getFirstName()));

        // Get all consultants
        List<Consultant> allConsultants = consultantService.getAll();
        allConsultants.forEach(c -> logger.info(c.getFirstName()));

        // Update a consultant's salary
        consultantService.updateConsultantSalary(1L, 6000D);

        // Delete consultant by ID
        consultantService.delete(1L);

        // USING EMPLOYEE
        // 1. Create a new employee
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("John");
        newEmployee.setLastName("Doe");
        newEmployee.setRole("Software Engineer");
        newEmployee.setSalary(80000.0);
        newEmployee.setSkills("QA");

        // Create the employee using the service
        employeeService.add(newEmployee);
        logger.info("Employee created with ID: {}", newEmployee.getId());

        // 2. Retrieve an employee by ID
        Optional<Employee> retrievedEmployee = employeeService.getById(newEmployee.getId());
        retrievedEmployee.ifPresentOrElse(
                employee -> logger.info("Retrieved Employee: {} {}", employee.getFirstName(), employee.getLastName()),
                () -> logger.info("Employee not found.")
        );

        // 3. Retrieve all employees
        List<Employee> allEmployees = employeeService.getAll();
        logger.info("All Employees:");
        for (Employee employee : allEmployees) {
            logger.info("{} {}", employee.getFirstName(), employee.getLastName());
        }

        // 4. Update an employee's details
        retrievedEmployee.ifPresent(employee -> {
            employeeService.updateEmployeeSkills(employee.getId(), "JAVA");
            logger.info("Updated Employee Skills for ID: {}", employee.getId());
        });

        // 5. Delete an employee
        retrievedEmployee.ifPresent(employee -> {
            employeeService.delete(employee.getId());
            logger.info("Deleted Employee with ID: {}", employee.getId());
        });

        // USING MANAGER
        // 1. Add a new manager
        Manager manager = new Manager();
        managerService.add(manager);
        logger.info("Manager added: {}", manager.getFirstName());

        // 2. Get manager by ID
        Optional<Manager> retrievedManager = managerService.getById(1L);
        retrievedManager.ifPresent(m -> logger.info("Manager found: {} {}", m.getFirstName(), m.getLastName()));

        // 3. Get all managers
        List<Manager> allManagers = managerService.getAll();
        allManagers.forEach(m -> logger.info("Manager: {}", m.getFirstName()));

        // 4. Get managers by project ID
        List<Manager> managersByProject = managerService.getManagersByProjectId(1L);
        managersByProject.forEach(m -> logger.info("Manager for Project: {}", m.getFirstName()));

        // 5. Get managers by salary range
        List<Manager> managersBySalaryRange = managerService.getManagersBySalaryRange(80000D, 120000D);
        managersBySalaryRange.forEach(m -> logger.info("Manager by Salary: {}", m.getFirstName()));

        // 6. Get managers by industry
        List<Manager> managersByIndustry = managerService.getManagersByIndustry("IT");
        managersByIndustry.forEach(m -> logger.info("Manager in IT: {}", m.getFirstName()));

        // 7. Get managers by skills
        List<Manager> managersBySkills = managerService.getManagersBySkills("Java");
        managersBySkills.forEach(m -> logger.info("Manager with Java skills: " + m.getFirstName()));

        // 8. Update manager's salary
        managerService.updateManagerSalary(1L, 95000D);
        logger.info("Manager salary updated.");

        // 9. Remove manager
        managerService.delete(1L);
        logger.info("Manager removed.");

        // 10. Remove managers by industry
        managerService.removeManagersByIndustry("IT");
        logger.info("Managers removed from IT industry.");

        // USING PROJECT
        // 1. Create a new project
        Project newProject = new Project();
        newProject.setName("New AI Development");
        newProject.setDeadline("2025-12-31");
        newProject.setBudget(1000000.0);
        newProject.setTechnology("AI, Machine Learning");

        // Create the project using the service
        projectService.add(newProject);
        logger.info("Project created with ID: {}", newProject.getId());

        // 2. Retrieve a project by ID
        Optional<Project> retrievedProject = projectService.getById(newProject.getId());
        if (retrievedProject.isPresent()) {
            logger.info("Retrieved Project: {}", retrievedProject.get().getName());
        } else {
            logger.info("Project not found.");
        }

        // 3. Retrieve all projects
        List<Project> allProjects = projectService.getAll();
        logger.info("All Projects:");
        for (Project project : allProjects) {
            logger.info(project.getName());
        }

        // 4. Update a project name
        projectService.updateProjectName(newProject.getId(), "Updated AI Development");
        logger.info("Updated Project Name.");

        // 5. Update project technology
        projectService.updateProjectTechnology(newProject.getId(), "AI, Deep Learning, Neural Networks");
        logger.info("Updated Project Technology.");

        // 6. Delete a project
        projectService.delete(newProject.getId());
        logger.info("Deleted Project with ID: {}", newProject.getId());

        // 7. Delete projects by technology
        projectService.deleteProjectsByTechnology("AI");
        logger.info("Deleted projects with AI technology.");

    }

}