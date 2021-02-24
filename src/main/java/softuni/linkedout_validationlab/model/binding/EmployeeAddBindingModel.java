package softuni.linkedout_validationlab.model.binding;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.linkedout_validationlab.model.entity.enums.EducationLevelsEnum;
import softuni.linkedout_validationlab.model.validation.AgeAbove;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeAddBindingModel {

    private String firstName;
    private String lastName;
    private EducationLevelsEnum educationLevel;
    private String company;
    private String jobTitle;
    private LocalDate birthDate;
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

    @AgeAbove(value = 18, message = "The employees' age must be min 18")
    @PastOrPresent(message = "Invalid birth date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @DecimalMin(value = "100", message = "Must input a min salary of 100!")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
