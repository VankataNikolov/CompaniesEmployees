package softuni.linkedout_validationlab.model.entity;

import softuni.linkedout_validationlab.model.entity.enums.EducationLevelsEnum;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class EmployeeEntity extends BaseEntity{

    private LocalDate birthDate;
    private EducationLevelsEnum educationLevel;
    private String firstName;
    private String jobTitle;
    private String lastName;
    private BigDecimal salary;
    private CompanyEntity company;

    public EmployeeEntity() {
    }

    @Column(name = "birth_date", nullable = false)
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "education_level")
    @Enumerated(EnumType.STRING)
    public EducationLevelsEnum getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevelsEnum educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Column(name = "first_name", nullable = false)
    @Size(min = 2)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "job_title", nullable = false)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Column(name = "last_name", nullable = false)
    @Size(min = 2)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "salary", nullable = false)
    @DecimalMin("0")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @ManyToOne
    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
