package org.example.models;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private Double salary;
    private String skills;
    private Manager manager;
    private Project project;

    public Employee(EmployeeBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
        this.salary = builder.salary;
        this.skills = builder.skills;
        this.project = builder.project;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public String getSkills() {
        return skills;
    }

    public Manager getManager() {
        return manager;
    }

    public Project getProject() {
        return project;
    }

    public static class EmployeeBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String role;
        private Double salary;
        private String skills;
        private Manager manager;
        private Project project;

        public Employee.EmployeeBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public Employee.EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Employee.EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Employee.EmployeeBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public Employee.EmployeeBuilder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public Employee.EmployeeBuilder setSkills(String skills) {
            this.skills = skills;
            return this;
        }

        public Employee.EmployeeBuilder setManager(Manager manager) {
            this.manager = manager;
            return this;
        }

        public Employee.EmployeeBuilder setProject(Project project) {
            this.project = project;
            return this;
        }

        public Employee build() {
            return new org.example.models.Employee(this);
        }
    }

}