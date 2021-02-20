package softuni.linkedout_validationlab.model.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "companies")
public class CompanyEntity extends BaseEntity{

    private BigDecimal budget;
    private String description;
    private String name;
    private String town;
    private Set<EmployeeEntity> employees;

    public CompanyEntity() {
    }

    @Column(name = "budget", nullable = false)
    @DecimalMin("0")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    @Size(min = 10)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "name", unique = true, nullable = false)
    @Size(min = 2, max = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "town", nullable = false)
    @Size(min = 2, max = 10)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE, orphanRemoval = true)
    public Set<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
