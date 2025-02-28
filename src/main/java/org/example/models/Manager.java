package org.example.models;

public class Manager {
    private Long id;
    private String firstName;
    private String lastName;
    private Double salary;
    private String industry;
    private String skills;
    private Consultant consultant;
    private Employee employee;

    public Manager(long managerId, String managerName) {

    }

    public Manager() {

    }

    private Manager(ManagerBuilder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.salary = builder.salary;
        this.industry = builder.industry;
        this.skills = builder.skills;
        this.consultant = builder.consultant;
        this.employee = builder.employee;

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

    public Double getSalary() {
        return salary;
    }

    public String getIndustry() {
        return industry;
    }

    public String getSkills() {
        return skills;
    }

    public static class ManagerBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private Double salary;
        private String industry;
        private String skills;
        private Consultant consultant;
        private Employee employee;

        public ManagerBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ManagerBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ManagerBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ManagerBuilder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public ManagerBuilder setIndustry(String industry) {
            this.industry = industry;
            return this;
        }

        public ManagerBuilder setSkills(String skills) {
            this.skills = skills;
            return this;
        }

        public Manager.ManagerBuilder setConsultant(Consultant consultant) {
            this.consultant = consultant;
            return this;
        }

        public Manager.ManagerBuilder setEmployee(Employee employee) {
            this.employee = employee;
            return this;
        }

        public Manager build() {
            return new Manager(this);
        }
    }

}
