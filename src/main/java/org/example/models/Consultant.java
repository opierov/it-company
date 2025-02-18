package org.example.models;

import jakarta.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Consultant")
@XmlAccessorType(XmlAccessType.FIELD)
public class Consultant {

    @XmlElement
    private Long id;

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElement
    private Double salary;

    @XmlElement
    private String industry;

    @XmlElement
    private Manager manager;

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "Project")
    private List<Project> projects;

    public Consultant() {}

    public Consultant(Long id, String firstName, String lastName, Double salary, String industry, Manager manager, List<Project> projects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.industry = industry;
        this.manager = manager;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public long getManager() {
        return manager.getId();
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}