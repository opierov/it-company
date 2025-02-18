package org.example.models;

import jakarta.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "Project")
@XmlAccessorType(XmlAccessType.FIELD)
public class Project {

    @XmlElement
    private Long id;

    @XmlElement
    private String name;

    @XmlElement
    private String deadline;

    @XmlElement
    private Double budget;

    @XmlElement
    private String technology;

    @XmlElement
    private Client client;

    @XmlElement
    private Manager manager;

    public Project() {}

    public Project(Long id, String name, String deadline, Double budget, String technology, Client client, Manager manager) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.budget = budget;
        this.technology = technology;
        this.client = client;
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

}
