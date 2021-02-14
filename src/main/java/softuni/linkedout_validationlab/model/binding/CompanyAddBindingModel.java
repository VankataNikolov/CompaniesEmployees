package softuni.linkedout_validationlab.model.binding;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class CompanyAddBindingModel {
    private BigDecimal budget;
    private String description;
    private String name;
    private String town;

    public CompanyAddBindingModel() {
    }

    @DecimalMin(value = "0", message = "Budget must be positive number")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Size(min = 10, message = "Description must be at least 10 characters")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Size(min = 2, max = 10, message = "Name length must be between 2 and 10 characters")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Size(min = 2, max = 10, message = "Town must be between 2 and 10 characters")
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
