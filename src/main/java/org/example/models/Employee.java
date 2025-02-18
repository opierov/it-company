package org.example.models;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {

    @XmlElement
    private Long id;

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElement
    private String role;

    @XmlElement
    private Double salary;

    @XmlElement
    private String skills;

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "Project")
    private List<Project> projects;

    public Employee() {}

    public Employee(Long id, String firstName, String lastName, String role, Double salary, String skills, List<Project> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.salary = salary;
        this.skills = skills;
        this.projects = projects;
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

    public Double getSalary() {
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

}
