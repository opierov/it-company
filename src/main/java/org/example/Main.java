package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.models.*;
import org.example.services.*;
import org.example.services.impl.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws ParseException {

        ClientService clientService = new ClientServiceImpl();
        ConsultantService consultantService = new ConsultantServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        ManagerService managerService = new ManagerServiceImpl();
        ProjectService projectService = new ProjectServiceImpl();

        // USING CLIENT
        // 1. Add a new client
        Client newClient = new Client(1L, "Apple", "john@example.com", "John", "Doe", new Project());
        clientService.addClient(newClient);
        logger.info("Client added: {}", newClient);

        // 2. Retrieve by ID
        clientService.getClientById(newClient.getId())
                .ifPresent(cli -> logger.info("Client: {}", cli));

        // 3. Get all clients
        clientService.getAllClients().forEach(logger::info);

        // 4. Update client
        newClient.setContactInfo("john.doe@example.com");
        clientService.updateClient(newClient);
        logger.info("Client updated: {}", newClient);

        // 5. Delete client
        clientService.deleteClient(newClient.getId());
        logger.info("Client deleted.");

        // Using CONSULTANT
        // 1. Add a new consultant
        Consultant newConsultant = new Consultant(null, "Jane", "Doe", 80000.0, "Finance", 1L);
        consultantService.addConsultant(newConsultant);
        logger.info("Consultant added: {}", newConsultant);

        // 2. Retrieve by ID
        consultantService.getConsultantById(newConsultant.getId()).ifPresent(con -> logger.info("Consultant: {}", con));

        // 3. Get all consultants
        consultantService.getAllConsultants().forEach(logger::info);

        // 4. Update consultant
        newConsultant.setSalary(85000.0);
        consultantService.updateConsultant(newConsultant);

        // 5. Delete consultant
        consultantService.deleteConsultant(newConsultant.getId());
        logger.info("Consultant deleted");

        // USING PROJECT
        // 1. Add a new project
        Date deadline = new SimpleDateFormat("yyyy-MM-dd").parse("2025-12-31");
        Project newProject = new Project(null, "AI Research", deadline, 500000.0, "Machine Learning");
        projectService.addProject(newProject);
        logger.info("Project added: {}", newProject);

        // 2. Retrieve by ID
        projectService.getProjectById(newProject.getId()).ifPresent(pro -> logger.info("Project: {}", pro));

        // 3. Get all projects
        projectService.getAllProjects().forEach(logger::info);

        // 4. Update project
        newProject.setBudget(600000.0);
        projectService.updateProject(newProject);

        // 5. Delete project
        projectService.deleteProject(newProject.getId());
        logger.info("Project deleted");

        // USING MANAGER
        // 1. Add a new manager
        Manager manager = new Manager(1, "Alice Johnson", 95000.0, "Finance");
        managerService.addManager(manager);
        logger.info("Manager added: {}", manager);

        // 2. Retrieve by ID
        managerService.getManagerById(1L).ifPresent(man -> logger.info("Manager: {}", man));

        // 3. Get all managers
        managerService.getAllManagers().forEach(logger::info);

        // 4. Update manager
        manager.setSalary(100000.0);
        managerService.updateManager(manager);
        logger.info("Updated manager: {}", manager);

        // 5. Delete manager
        managerService.deleteManager(1L);
        logger.info("Manager deleted");

        // USING EMPLOYEE
        // 1. Add an employee
        Employee employee = new Employee(101, "John Doe", "Software Engineer", 85000.00, Arrays.asList("Java", "SQL", "Spring"));
        employeeService.addEmployee(employee);
        logger.info("Employee added: {}", employee);

        // 2. Retrieve by ID
        employeeService.getEmployeeById(101L).ifPresent(emp -> logger.info("Retrieved: {}", emp));

        // 3. Get all employees
        logger.info("All Employees: ");
        employeeService.getAllEmployees().forEach(logger::info);

        // 4. Update an employee
        employee.setSalary(90000.00);
        employeeService.updateEmployee(employee);
        logger.info("Updated: {}", employee);

        // 5. Delete an employee
        employeeService.deleteEmployee(101L);
        logger.info("Employee deleted");

    }

}
