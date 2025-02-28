package org.example.models;

public class Project {
    private Long id;
    private String name;
    private String deadline;
    private Double budget;
    private String technology;
    private Manager manager;
    private Client client;

    private Project(ProjectBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.deadline = builder.deadline;
        this.budget = builder.budget;
        this.technology = builder.technology;
        this.manager = builder.manager;
        this.client = builder.client;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeadline() {
        return deadline;
    }

    public Double getBudget() {
        return budget;
    }

    public String getTechnology() {
        return technology;
    }

    public static class ProjectBuilder {
        private Long id;
        private String name;
        private String deadline;
        private Double budget;
        private String technology;
        private Manager manager;
        private Client client;

        public ProjectBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ProjectBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProjectBuilder setDeadline(String deadline) {
            this.deadline = deadline;
            return this;
        }

        public ProjectBuilder setBudget(Double budget) {
            this.budget = budget;
            return this;
        }

        public ProjectBuilder setTechnology(String technology) {
            this.technology = technology;
            return this;
        }

        public ProjectBuilder setClient(Client client) {
            this.client = client;
            return this;
        }

        public ProjectBuilder setManager(Manager manager) {
            this.manager = manager;
            return this;
        }

        public Project build() {
            return new Project(this);
        }
    }

}
