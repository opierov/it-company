package org.example.models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private Double salary;
    private String skills;
    private List<Project> projects;

    public Employee(org.example.models.Employee.EmployeeBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.role = builder.role;
        this.salary = builder.salary;
        this.skills = builder.skills;
        this.projects = builder.projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public static class EmployeeBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String role;
        private Double salary;
        private String skills;
        private List<Project> projects = new ArrayList<>();

        public org.example.models.Employee.EmployeeBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public org.example.models.Employee.EmployeeBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public org.example.models.Employee.EmployeeBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public org.example.models.Employee.EmployeeBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public org.example.models.Employee.EmployeeBuilder setSalary(Double salary) {
            this.salary = salary;
            return this;
        }

        public org.example.models.Employee.EmployeeBuilder setSkills(String skills) {
            this.skills = skills;
            return this;
        }

        public org.example.models.Employee.EmployeeBuilder setProjects(List<Project> projects) {
            this.projects = projects;
            return this;
        }

        public org.example.models.Employee build() {
            return new org.example.models.Employee(this);
        }
    }

}
