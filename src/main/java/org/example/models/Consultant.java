package org.example.models;

public class Consultant {
    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private String industry;
    private Manager manager;
    private Project project;

    public Consultant(Long id, String firstName, String lastName, Double salary, String industry, Manager manager) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.industry = industry;
        this.manager = manager;
    }

    private Consultant(ConsultantBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.salary = builder.salary;
        this.industry = builder.industry;
        this.manager = builder.manager;
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

    public double getSalary() {
        return salary;
    }

    public String getIndustry() {
        return industry;
    }

    public Manager getManager() {
        return manager;
    }

    public long getManagerId() {
        return manager != null ? manager.getId() : 0;
    }

    public static class ConsultantBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Double salary;
        private String industry;
        private Manager manager;
        private Project project;

        public ConsultantBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ConsultantBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ConsultantBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ConsultantBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public ConsultantBuilder setIndustry(String industry) {
            this.industry = industry;
            return this;
        }

        public ConsultantBuilder setManager(Manager manager) {
            this.manager = manager;
            return this;
        }

        public ConsultantBuilder setProject(Project project) {
            this.project = project;
            return this;
        }

        public Consultant build() {
            return new Consultant(this);
        }
    }

}