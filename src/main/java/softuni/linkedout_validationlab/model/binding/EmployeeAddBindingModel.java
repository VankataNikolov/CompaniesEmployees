package softuni.linkedout_validationlab.model.binding;

import softuni.linkedout_validationlab.model.entity.enums.EducationLevelsEnum;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class EmployeeAddBindingModel {

    private String firstName;
    private String lastName;
    private EducationLevelsEnum educationLevel;
    private String company;
    private String jobTitle;
    private String birthDate;
    private BigDecimal salary;

    public EmployeeAddBindingModel() {
    }

    @NotBlank(message = "First Name must not be blank !")
    @Size(min = 2, message = "First Name must be at least 2 characters !")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @NotBlank(message = "Last Name must not be blank !")
    @Size(min = 2, message = "Last Name must be at least 2 characters !")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotNull(message = "Must select education level !")
    public EducationLevelsEnum getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevelsEnum educationLevel) {
        this.educationLevel = educationLevel;
    }

    @NotBlank(message = "Must choose a company name")
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @NotBlank(message = "Must write a job title")
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @NotBlank(message = "Must select a birth date !")
    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    @DecimalMin(value = "0", message = "Must input a salary !")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
