package softuni.linkedout_validationlab.model.service;

import softuni.linkedout_validationlab.model.entity.enums.EducationLevelsEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeServiceModel {

    private LocalDate birthDate;
    private EducationLevelsEnum educationLevel;
    private String firstName;
    private String jobTitle;
    private String lastName;
    private BigDecimal salary;
    private CompanyServiceModel company;

    public EmployeeServiceModel() {
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public EducationLevelsEnum getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevelsEnum educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public CompanyServiceModel getCompany() {
        return company;
    }

    public void setCompany(CompanyServiceModel company) {
        this.company = company;
    }
}
