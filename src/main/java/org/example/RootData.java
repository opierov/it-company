package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.models.*;

import java.util.List;

public class RootData {

    @JsonProperty("employees")
    private List<Employee> employees;

    @JsonProperty("clients")
    private List<Client> clients;

    @JsonProperty("projects")
    private List<Project> projects;

    @JsonProperty("consultants")
    private List<Consultant> consultants;

    @JsonProperty("managers")
    private List<Manager> managers;

    // Getters and Setters
    public List<Employee> getEmployees() { return employees; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }

    public List<Client> getClients() { return clients; }
    public void setClients(List<Client> clients) { this.clients = clients; }

    public List<Project> getProjects() { return projects; }
    public void setProjects(List<Project> projects) { this.projects = projects; }

    public List<Consultant> getConsultants() { return consultants; }
    public void setConsultants(List<Consultant> consultants) { this.consultants = consultants; }

    public List<Manager> getManagers() { return managers; }
    public void setManagers(List<Manager> managers) { this.managers = managers; }

    @Override
    public String toString() {
        return "RootData{" +
                "employees=" + employees +
                ", clients=" + clients +
                ", projects=" + projects +
                ", consultants=" + consultants +
                ", managers=" + managers +
                '}';
    }
}